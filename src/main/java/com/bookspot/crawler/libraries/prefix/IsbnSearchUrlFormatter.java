package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

public interface IsbnSearchUrlFormatter {
    boolean supports(LibraryPageDto homePage);
    String getLibraryCode(LibraryPageDto homePage);
    String format(LibraryPageDto homePage);
}
