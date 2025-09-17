package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

public abstract class UnsupportedSearchLibraryFormatter implements IsbnSearchUrlFormatter {
    @Override
    public abstract boolean supports(LibraryPageDto dto);

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    @Override
    public String format(LibraryPageDto dto) {
        return null;
    }
}
