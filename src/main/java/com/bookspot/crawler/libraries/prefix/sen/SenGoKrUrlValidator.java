package com.bookspot.crawler.libraries.prefix.sen;

import com.bookspot.crawler.libraries.prefix.IsbnUrlValidator;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class SenGoKrUrlValidator implements IsbnUrlValidator {
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        String url = prefix + expectedIsbn;
        log.trace("페이지 확인 중: {}", url);

        // JSoup을 사용하여 페이지 파싱
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                .timeout(20_000)
                .get();

        // ISBN 검색창 확인 (libraryCode는 null이므로 무시)
        boolean isbnFound = checkIsbnInput(doc, expectedIsbn);

        log.trace("ISBN ({}) 입력 상태: {}", expectedIsbn, isbnFound);
        log.info("최종 검사 결과: {}", isbnFound);

        return isbnFound;
    }

    private boolean checkIsbnInput(Document doc, String expectedIsbn) {
        log.trace("ISBN 검색창 확인 시작");

        // 1. 일반적인 input 필드들 확인
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

            // search_text 파라미터 관련 필드 확인
            if ("search_text".equals(name) || name.contains("search") || name.contains("text")) {
                log.trace("검색 관련 필드: {} = {}", name, value);
            }
        }

        // 2. URL 파라미터에서 search_text 확인
        if (doc.location().contains("search_text=" + expectedIsbn)) {
            log.trace("URL 파라미터에서 ISBN 확인됨 (search_text)");
            return true;
        }

        // 3. JavaScript로 설정된 값들을 확인하기 위해 script 태그도 체크
        Elements scripts = doc.select("script");
        for (Element script : scripts) {
            String scriptContent = script.html();
            if (scriptContent.contains(expectedIsbn)) {
                log.trace("Script 태그에서 ISBN 발견");
                // 추가로 검색 관련 변수에 설정되어 있는지 확인
                if (scriptContent.contains("search_text") ||
                        scriptContent.contains("searchText") ||
                        scriptContent.contains("keyword")) {
                    log.trace("Script에서 검색 관련 변수에 ISBN이 설정됨");
                    return true;
                }
            }
        }

        // 4. 검색 결과가 표시되어 있는지 확인 (이미 검색이 수행된 상태)
        Elements searchResults = doc.select(".search-result, .book-list, .result-list, [class*=result], [class*=search]");
        if (!searchResults.isEmpty()) {
            log.trace("검색 결과 영역 발견, 검색이 수행된 것으로 판단");

            // 검색 결과에 ISBN이나 관련 정보가 있는지 확인
            for (Element result : searchResults) {
                if (result.text().contains(expectedIsbn)) {
                    log.trace("검색 결과에서 ISBN 발견");
                    return true;
                }
            }
        }

        // 5. 메타 태그에서 검색 키워드 확인
        Elements metaTags = doc.select("meta[name*=keyword], meta[property*=keyword]");
        for (Element meta : metaTags) {
            String content = meta.attr("content");
            if (content.contains(expectedIsbn)) {
                log.trace("메타 태그에서 ISBN 발견: {}", content);
                return true;
            }
        }

        // 6. 히든 필드 확인
        Elements hiddenInputs = doc.select("input[type=hidden]");
        for (Element hidden : hiddenInputs) {
            String name = hidden.attr("name");
            String value = hidden.attr("value");

            if (expectedIsbn.equals(value)) {
                log.trace("히든 필드에서 ISBN 발견: {} = {}", name, value);
                return true;
            }
        }

        return false;
    }
}
