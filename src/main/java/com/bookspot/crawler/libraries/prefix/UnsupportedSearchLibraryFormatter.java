package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

// 도서 검색 자체를 지원하지 않음.
public abstract class UnsupportedSearchLibraryFormatter implements IsbnSearchUrlFormatter {
    @Override
    public abstract boolean supports(LibraryPageDto dto);
}
