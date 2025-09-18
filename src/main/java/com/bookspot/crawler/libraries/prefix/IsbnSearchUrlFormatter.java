package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

import java.util.Map;

public interface IsbnSearchUrlFormatter extends BasicUrlFormatElements {

    default boolean supports(LibraryPageDto dto) {
        String[] domains = getDomains();
        for (String domain : domains) {
            if(dto.homePage().contains(domain))
                return true;
        }
        return false;
    }

    default String getLibraryCode(LibraryPageDto dto) {
        Map<String, String> libraryNameAndCode = getLibraryNameAndCode();
        if(libraryNameAndCode == null)
            return null;
        String code = libraryNameAndCode.get(dto.name());
        if(code == null)
            throw new IllegalArgumentException("지원하지 않는 도서관 코드 = " + dto);
        return code;
    }

    default String format(LibraryPageDto dto) {
        if(getTemplate() == null)
            return null;

        if(getTemplate().contains("%s"))
            return getTemplate().formatted(getLibraryCode(dto));
        else
            return getTemplate();
    }
}
