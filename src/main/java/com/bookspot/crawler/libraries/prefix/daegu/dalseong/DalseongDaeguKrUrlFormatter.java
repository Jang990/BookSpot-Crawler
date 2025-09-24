package com.bookspot.crawler.libraries.prefix.daegu.dalseong;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.UnsupportedSearchLibraryFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DalseongDaeguKrUrlFormatter extends UnsupportedSearchLibraryFormatter {

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toMultiDomain(
                "dalseong.daegu.kr",
                "dalseonglib.kr" // 달성군립도서관
        );
    }

    @Override
    public String getTemplate() {
        return "https://library.daegu.go.kr/dalseonglib/intro/search/index.do?menu_idx=9&booktype=BOOKANDNONBOOK&rowCount=30&libraryCodes=%s&isbn=";
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("달성군립도서관", "BR"),
                Map.entry("화원읍 작은도서관", "GA"),
                Map.entry("논공읍 작은도서관", "GB"),
                Map.entry("다사읍 작은도서관", "HG"),
                Map.entry("다사읍 서재 작은도서관", "GD"),
                Map.entry("유가읍 작은도서관", "GF"),
                Map.entry("옥포읍 작은도서관", "GH"),
                Map.entry("가창면 참꽃 작은도서관", "FR"),
                Map.entry("하빈면 작은도서관", "GE"),
                Map.entry("구지면 작은도서관", "GC"),
                Map.entry("달성군청소년센터", "FN"),
                Map.entry("달성군청도서관", "FJ"),
                Map.entry("달성어린이숲도서관", "CD")
        );
    }
}
