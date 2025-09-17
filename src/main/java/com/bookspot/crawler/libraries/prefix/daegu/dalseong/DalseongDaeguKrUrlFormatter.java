package com.bookspot.crawler.libraries.prefix.daegu.dalseong;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.UnsupportedSearchLibraryFormatter;

public class DalseongDaeguKrUrlFormatter extends UnsupportedSearchLibraryFormatter {
    private static final String DOMAIN = "dalseong.daegu.kr";

    @Override
    public boolean supports(LibraryPageDto dto) {
        return dto.homePage().contains(DOMAIN);
    }
}
