package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class JinjuUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("jinju.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("진주시립연암도서관", "MA"),
                Map.entry("진주시립어린이전문도서관", "BC"),
                Map.entry("진주시립도동어린이도서관", "DC"),
                Map.entry("진주시립비봉어린이도서관", "LC"),
                Map.entry("진주시립서부도서관", "BR"),
                Map.entry("진주시립혁신어린이도서관", "HM"),
                Map.entry("진주시립남부어린이도서관", "SO")
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.jinju.go.kr/dls_lt/index.php?mod=wdDataSearch&deSearch=1&act=searchResultList&manageCode=%s&isbn=";
    }
}
