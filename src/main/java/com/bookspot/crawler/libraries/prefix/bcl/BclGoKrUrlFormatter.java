package com.bookspot.crawler.libraries.prefix.bcl;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;


public class BclGoKrUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN_1 = "bcsl.go.kr";
    private static final String DOMAIN_2 = "bcl.go.kr";
    private static final String COMMON_SEARCH_PAGE = "https://alpasq.bcl.go.kr/search/keyword/";

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toMultiDomain(DOMAIN_1, DOMAIN_2);
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    // CSR 방식 같아서 직접 사용자가 클릭하는 방식이 유효. url단에서 설정해서 들어갈 수 없어보임
    @Override
    public String format(LibraryPageDto dto) {
        return COMMON_SEARCH_PAGE;
    }
}
