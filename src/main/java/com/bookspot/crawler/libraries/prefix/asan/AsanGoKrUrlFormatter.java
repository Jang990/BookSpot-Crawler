package com.bookspot.crawler.libraries.prefix.asan;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class AsanGoKrUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN = "asan.go.kr";
    private static final String COMMON_SEARCH_PAGE = "https://lib.asan.go.kr/dls_le/index.php?act=searchIList&manageCode=%s&isbn=";

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain(DOMAIN);
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("아산시 중앙도서관", "MF"),
                Map.entry("아산시 꿈샘어린이청소년도서관", "CH"),
                Map.entry("아산시 탕정온샘도서관", "ME"),
                Map.entry("아산시 배방월천도서관", "MI"),
                Map.entry("아산시 음봉어울샘도서관", "MH"),
                Map.entry("아산시 배방도서관", "MC"),
                Map.entry("아산시 둔포도서관", "MB")
        );
    }

    @Override
    public String getTemplate() {
        return COMMON_SEARCH_PAGE;
    }

    @Override
    public String format(LibraryPageDto dto) {
        return COMMON_SEARCH_PAGE.formatted(getLibraryCode(dto));
    }
}
