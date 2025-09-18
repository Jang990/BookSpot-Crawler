package com.bookspot.crawler.libraries.prefix.geumcheon;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class GeumcheonUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String prefix = "https://geumcheonlib.seoul.kr/geumcheonlib/uce/search/totalList.do?selfId=1097&manageCode=%s&advIsbn=";

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("geumcheonlib.seoul.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("금천구립가산도서관", "BR"),
                Map.entry("금천구립시흥도서관", "CB"),
                Map.entry("금천구립독산도서관", "MA"),
                Map.entry("금천구립금나래도서관", "NR")
        );
    }

    @Override
    public String format(LibraryPageDto dto) {
        return prefix.formatted(getLibraryCode(dto));
    }
}
