package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GwangyangUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gwangyang.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("광양희망도서관", "ME"),
                Map.entry("광양용강도서관", "MD"),
                Map.entry("광양중마도서관", "MB"),
                Map.entry("광양중앙도서관", "MA"),
                Map.entry("광양광영도서관", "MG"),
                Map.entry("광양금호도서관", "MF")
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.gwangyang.go.kr/lib/book/search/searchIndex.do?nPageSize=50&manageCd=%s&search=";
    }
}
