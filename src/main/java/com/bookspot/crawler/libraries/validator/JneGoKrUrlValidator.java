package com.bookspot.crawler.libraries.validator;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class JneGoKrUrlValidator implements IsbnUrlValidator {

    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        log.trace("페이지 확인 중: {}", prefix);

        // JSoup을 사용하여 페이지 파싱
        Document doc = Jsoup.connect(prefix + expectedIsbn)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                .timeout(10000)
                .get();

        // 1. ISBN 검색창 확인
        boolean isbnFound = checkIsbnInput(doc, expectedIsbn);

        // 2. 검색 종류 체크박스/라디오버튼 확인
        boolean searchKindChecked = checkSearchKind(doc, targetSearchKind);

        // 3. 결과 로그
        log.trace("ISBN ({}) 입력 상태: {}", expectedIsbn, isbnFound);
        log.trace("검색종류 ({}) 선택 상태: {}", targetSearchKind, searchKindChecked);

        boolean result = isbnFound && searchKindChecked;
        log.trace("최종 검사 결과: {}", result);

        return result;
    }

    private boolean checkIsbnInput(Document doc, String expectedIsbn) {
        log.trace("ISBN 검색창 확인 시작");

        // 다양한 가능성의 input 필드들 확인
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

            // vSrchText0은 URL 파라미터에서 온 것 같으니 이것도 확인
            if ("vSrchText0".equals(name) || name.contains("srch") || name.contains("search")) {
                log.trace("검색 관련 필드: {} = {}", name, value);
            }
        }

        // URL 파라미터도 확인 (페이지가 파라미터를 통해 값을 설정했을 수 있음)
        if (doc.location().contains("vSrchText0=" + expectedIsbn)) {
            log.trace("URL 파라미터에서 ISBN 확인됨");
            return true;
        }

        return false;
    }

    private boolean checkSearchKind(Document doc, String targetSearchKind) {
        log.trace("검색 종류 선택 상태 확인 시작");

        // 라디오 버튼 확인
        Elements radioInputs = doc.select("input[type=radio]");
        for (Element radio : radioInputs) {
            String name = radio.attr("name");
            String value = radio.attr("value");
            boolean checked = radio.hasAttr("checked");

            log.trace("Radio 버튼 - name: {}, value: {}, checked: {}", name, value, checked);

            if (targetSearchKind.equals(value) && checked) {
                log.trace("목표 검색종류가 선택됨: {}", value);
                return true;
            }
        }

        // 체크박스 확인
        Elements checkboxInputs = doc.select("input[type=checkbox]");
        for (Element checkbox : checkboxInputs) {
            String name = checkbox.attr("name");
            String value = checkbox.attr("value");
            boolean checked = checkbox.hasAttr("checked");

            log.trace("Checkbox - name: {}, value: {}, checked: {}", name, value, checked);

            if (targetSearchKind.equals(value) && checked) {
                log.trace("목표 검색종류가 선택됨: {}", value);
                return true;
            }
        }

        // select 옵션 확인
        Elements selects = doc.select("select");
        for (Element select : selects) {
            String name = select.attr("name");
            Elements options = select.select("option");

            log.trace("Select 박스 - name: {}", name);

            for (Element option : options) {
                String value = option.attr("value");
                boolean selected = option.hasAttr("selected");

                if (selected) {
                    log.trace("선택된 옵션: {} ({})", value, option.text());
                }

                if (targetSearchKind.equals(value) && selected) {
                    log.trace("목표 검색종류가 선택됨: {}", value);
                    return true;
                }
            }
        }

        return false;
    }
}
