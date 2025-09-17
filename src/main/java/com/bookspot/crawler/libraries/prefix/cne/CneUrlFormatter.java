package com.bookspot.crawler.libraries.prefix.cne;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

public class CneUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN = "cne.go.kr";

    @Override
    public boolean supports(LibraryPageDto dto) {
        return dto.homePage().contains(DOMAIN);
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        return "";
    }

    @Override
    public String format(LibraryPageDto dto) {
        return "";
    }
}
