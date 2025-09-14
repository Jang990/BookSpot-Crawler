package com.bookspot.crawler.libraries;

import java.util.Map;

public class JneGoKrIsbnSearchUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String SUPPORTED_DOMAIN = "jne.go.kr";
    private static final String COMMON_ISBN_PREFIX_FORMAT = "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=%s&vSrchText0=";
    private static final Map<String, String> homePageAndCode = Map.of(
            "http://bglib.jne.go.kr/", "00146013", // 벌교
            "http://bslib.jne.go.kr/", "00146012" // 보성
    );

    public boolean supports(String homePage) {
        return homePage.contains(SUPPORTED_DOMAIN);
    }

    public String format(String homePage) {
        if(!homePageAndCode.containsKey(homePage))
            throw new IllegalArgumentException("지원하지 않는 홈페이지. homePageAndCode에 관련 데이터 추가 필요 => " + homePage);
        return COMMON_ISBN_PREFIX_FORMAT.formatted(homePageAndCode.get(homePage));
    }
}
