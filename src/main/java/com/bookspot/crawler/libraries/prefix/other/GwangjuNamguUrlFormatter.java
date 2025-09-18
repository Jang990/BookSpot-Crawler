package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class GwangjuNamguUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("namgu.gwangju.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("광주남구푸른길도서관", "MB"),
                Map.entry("광주남구문화정보도서관", "MA"),
                Map.entry("광주남구청소년도서관", "MC")
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.namgu.gwangju.kr/main/bookSearch?libCodeArr=%s"+"&";
    }
}
