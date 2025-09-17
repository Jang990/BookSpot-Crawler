package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

public interface IsbnSearchUrlFormatter {
    boolean supports(LibraryPageDto dto);
    String getLibraryCode(LibraryPageDto dto);
    String format(LibraryPageDto dto);
}
