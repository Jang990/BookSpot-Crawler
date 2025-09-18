package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

public interface IsbnSearchUrlFormatter {
    static String[] toSingleDomain(String domain) {
        return new String[]{domain};
    }

    static String[] toMultiDomain(String... domains) {
        return domains;
    }

    String[] getDomains();

    default boolean supports(LibraryPageDto dto) {
        String[] domains = getDomains();
        for (String domain : domains) {
            if(dto.homePage().contains(domain))
                return true;
        }
        return false;
    }

    default String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    default String format(LibraryPageDto dto) {
        return null;
    }
}
