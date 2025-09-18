package com.bookspot.crawler.libraries.prefix.donghae;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class DongHaeUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN = "donghaelib.go.kr";
    private static final String PREFIX = "https://donghaelib.go.kr/web/menu/10004/program/30002/searchResultList.do?searchType=DETAIL&searchLibrary=%s&searchWordIsbn=";

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain(DOMAIN);
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.of(
                "등대작은도서관", "MD",
                "무릉작은도서관", "MC",
                "동해시립북삼도서관", "MA",
                "동해시립발한도서관", "MB",
                "이도작은도서관", "ME",
                "동해시립꿈빛마루도서관", "MF"
        );
    }

    @Override
    public String format(LibraryPageDto dto) {
        return PREFIX.formatted(getLibraryCode(dto));
    }
}
