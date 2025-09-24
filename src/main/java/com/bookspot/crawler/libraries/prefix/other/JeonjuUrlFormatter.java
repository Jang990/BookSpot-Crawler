package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JeonjuUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("jeonju.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("전주시립서신도서관", "WT"),
                Map.entry("전주시립건지도서관", "MC"),
                Map.entry("전주시립삼천도서관", "ST"),
                Map.entry("전주시립아중도서관", "MB"),
                Map.entry("전주시립완산도서관", "MA"),
                Map.entry("전주시립효자도서관", "HJ"),
                Map.entry("전주시립평화도서관", "PH"),
                Map.entry("전주시립쪽구름도서관", "JT"),
                Map.entry("전주시립금암도서관", "GT"),
                Map.entry("전주시립송천도서관", "DT"),
                Map.entry("전주시립인후도서관", "IT"),
                Map.entry("전주시립도서관 꽃심", "JL")
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.jeonju.go.kr/index.jeonju?menuCd=DOM_000000101001001000&display=50&book_type=BOOK&manage_code=%s&search_txt=";
    }
}
