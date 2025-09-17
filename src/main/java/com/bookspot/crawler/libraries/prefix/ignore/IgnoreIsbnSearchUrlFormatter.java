package com.bookspot.crawler.libraries.prefix.ignore;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.List;

public class IgnoreIsbnSearchUrlFormatter implements IsbnSearchUrlFormatter {
    private static List<String> WHITE_LIST = List.of(
            "agjlib.gangnam.go.kr",
            "cafe.daum.net/ddmbook"
    );

    @Override
    public boolean supports(LibraryPageDto dto) {
        if(dto.homePage() == null
                || dto.homePage().equals("")
                || dto.homePage().equals("-"))
            return true;

        for (String url : WHITE_LIST) {
            if(dto.homePage().contains(url))
                return true;
        }

        return false;
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    @Override
    public String format(LibraryPageDto dto) {
        return null;
    }
}
