package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

public abstract class UnsupportedSearchLibraryFormatter implements IsbnSearchUrlFormatter {
    @Override
    public abstract boolean supports(LibraryPageDto dto);
}
