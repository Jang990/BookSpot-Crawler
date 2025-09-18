package com.bookspot.crawler.libraries.prefix.cne;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

public class CneUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN = "cne.go.kr";

    @Override
    public String[] getDomains() {
        return IsbnSearchUrlFormatter.toSingleDomain(DOMAIN);
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    @Override
    public String format(LibraryPageDto dto) {
        String homePage = dto.homePage();
        if(homePage.endsWith("/"))
            return homePage + "api/srch/bookSearch.do?searchCondition=ALL&searchTxt=";
        else
            return homePage + "/api/srch/bookSearch.do?searchCondition=ALL&searchTxt=";
    }
}
