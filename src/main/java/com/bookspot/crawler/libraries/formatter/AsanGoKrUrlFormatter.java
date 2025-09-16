package com.bookspot.crawler.libraries.formatter;

import com.bookspot.crawler.libraries.file.LibraryPageDto;

import java.util.Map;

public class AsanGoKrUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN = "asan.go.kr";
    private static final String COMMON_SEARCH_PAGE = "https://lib.asan.go.kr/dls_le/index.php?act=searchIList&manageCode=%s&isbn=";
    private static final Map<String, String> libCodes = Map.ofEntries(
            Map.entry("아산시 중앙도서관", "MF"),
            Map.entry("아산시 꿈샘어린이청소년도서관", "CH"),
            Map.entry("아산시 탕정온샘도서관", "ME"),
            Map.entry("아산시 배방월천도서관", "MI"),
            Map.entry("아산시 음봉어울샘도서관", "MH"),
            Map.entry("아산시 배방도서관", "MC"),
            Map.entry("아산시 둔포도서관", "MB")
    );

    @Override
    public boolean supports(LibraryPageDto dto) {
        return dto.homePage().contains(DOMAIN);
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        String result = libCodes.get(dto.name());
        if(result == null)
            throw new IllegalArgumentException("지원하지 않는 도서관 코드 = " + dto);
        return result;
    }

    @Override
    public String format(LibraryPageDto dto) {
        return COMMON_SEARCH_PAGE.formatted(getLibraryCode(dto));
    }
}
