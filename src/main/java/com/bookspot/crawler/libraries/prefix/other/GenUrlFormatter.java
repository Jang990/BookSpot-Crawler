package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class GenUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gen.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.of(
                "광주광역시교육청학생교육문화회관", "MC",
                "광주광역시교육청금호평생교육관", "MB",
                "광주광역시교육청중앙도서관", "MD",
                "광주광역시교육청중앙도서관 분관 최상준도서관", "MF",
                "광주광역시교육청송정다가치문화도서관", "ME",
                "광주광역시교육청학생독립운동기념회관", "MA"
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.gen.go.kr/jungang/site/search/bookSearch.do?detail=ok&cmd_name=bookandnonbooksearch&search_type=detail&manage_code=%s&search_isbn_issn=";
    }
}
