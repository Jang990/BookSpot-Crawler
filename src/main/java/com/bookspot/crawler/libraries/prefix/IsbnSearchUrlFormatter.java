package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

public interface IsbnSearchUrlFormatter {
    boolean supports(LibraryPageDto dto);

    default String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    default String format(LibraryPageDto dto) {
        return null;
    }
}
