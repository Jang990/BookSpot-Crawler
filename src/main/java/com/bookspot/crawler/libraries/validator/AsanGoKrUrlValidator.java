package com.bookspot.crawler.libraries.validator;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;

@Slf4j
@Component
public class AsanGoKrUrlValidator implements IsbnUrlValidator {

    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        String url = prefix + expectedIsbn;
        log.trace("페이지 확인 중: {}", url);

        try {
            // JSoup을 사용하여 페이지 파싱 (타임아웃 증가)
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                    .timeout(30000) // 30초로 증가
                    .get();

            // 1. ISBN 검색 확인
            boolean isbnFound = checkIsbnInput(doc, expectedIsbn);

            // 2. 도서관 코드 확인 (manageCode)
            boolean libraryCodeFound = checkLibraryCode(doc, targetSearchKind);

            log.trace("ISBN ({}) 입력 상태: {}", expectedIsbn, isbnFound);
            log.trace("도서관 코드 ({}) 설정 상태: {}", targetSearchKind, libraryCodeFound);

            boolean result = isbnFound && libraryCodeFound;
            log.trace("최종 검사 결과: {}", result);

            return result;

        } catch (SocketTimeoutException e) {
            log.warn("타임아웃 발생: {}", prefix);
            throw e;
        }
    }

    private boolean checkIsbnInput(Document doc, String expectedIsbn) {
        log.trace("ISBN 검색 확인 시작");

        // 1. URL 파라미터에서 isbn 확인
        if (doc.location().contains("isbn=" + expectedIsbn)) {
            log.trace("URL 파라미터에서 ISBN 확인됨");
            return true;
        }

        // 2. 일반적인 input 필드들 확인
        Elements inputs = doc.select("input[type=text], input[type=search], input:not([type])");

        for (Element input : inputs) {
            String name = input.attr("name");
            String id = input.attr("id");
            String value = input.attr("value");

            log.trace("Input 발견 - name: {}, id: {}, value: {}", name, id, value);

            // ISBN이 입력되어 있는지 확인
            if (expectedIsbn.equals(value)) {
                log.trace("ISBN이 입력된 필드 발견: {} (id: {})", name, id);
                return true;
            }

            // isbn 관련 필드 확인
            if ("isbn".equals(name) || name.contains("isbn") ||
                    name.contains("search") || name.contains("keyword")) {
                log.trace("검색 관련 필드: {} = {}", name, value);
            }
        }

        // 3. 히든 필드 확인
        Elements hiddenInputs = doc.select("input[type=hidden]");
        for (Element hidden : hiddenInputs) {
            String name = hidden.attr("name");
            String value = hidden.attr("value");

            if (expectedIsbn.equals(value) && ("isbn".equals(name) || name.contains("isbn"))) {
                log.trace("히든 필드에서 ISBN 발견: {} = {}", name, value);
                return true;
            }
        }

        // 4. JavaScript 변수 확인
        Elements scripts = doc.select("script");
        for (Element script : scripts) {
            String scriptContent = script.html();
            if (scriptContent.contains(expectedIsbn)) {
                log.trace("Script 태그에서 ISBN 발견");
                if (scriptContent.contains("isbn") ||
                        scriptContent.contains("search") ||
                        scriptContent.contains("keyword")) {
                    log.trace("Script에서 ISBN 관련 변수 설정됨");
                    return true;
                }
            }
        }

        // 5. 검색 결과에서 ISBN 확인 (이미 검색 실행된 경우)
        Elements searchResults = doc.select(".search-result, .book-list, .result-list, " +
                "[class*=result], [class*=search], [class*=book], .list-item, tr");

        for (Element result : searchResults) {
            if (result.text().contains(expectedIsbn)) {
                log.trace("검색 결과에서 ISBN 발견");
                return true;
            }
        }

        return false;
    }

    private boolean checkLibraryCode(Document doc, String libraryCode) {
        log.trace("도서관 코드 확인 시작 (Asan #selManageCode): {}", libraryCode);

        // #selManageCode select 요소 가져오기
        Element select = doc.selectFirst("#selManageCode");
        if (select != null) {
            Elements selectedOption = select.select("option[selected]");
            if (!selectedOption.isEmpty()) {
                /*
                이상하게 전체도 selected 되있으나 정상 검색됨
                <option value="" selected>전체</option>
                <option value="MF" selected>아산중앙도서관</option>
                 */
                String value = selectedOption.get(1).attr("value");
                log.trace("#selManageCode에서 선택된 옵션 값: {}", value);
                return libraryCode.equals(value);
            }
            // fallback: value 속성만 체크
            Elements options = select.select("option");
            for (Element option : options) {
                if (libraryCode.equals(option.attr("value"))) {
                    log.trace("#selManageCode에서 option 값 확인됨: {}", option.attr("value"));
                    return true;
                }
            }
        } else {
            log.warn("#selManageCode select 요소를 찾을 수 없음 | {}", libraryCode);
        }

        return false;
    }

}
