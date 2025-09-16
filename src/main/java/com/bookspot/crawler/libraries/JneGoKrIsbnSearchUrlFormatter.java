package com.bookspot.crawler.libraries;

import java.util.Map;

public class JneGoKrIsbnSearchUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String SUPPORTED_DOMAIN = "jne.go.kr";
    private static final String COMMON_ISBN_PREFIX_FORMAT = "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=%s&vSrchText0=";
    public static final Map<String, String> homePageAndCode = Map.ofEntries(
            Map.entry("http://bglib.jne.go.kr/", "00146013"), // 벌교
            Map.entry("http://bslib.jne.go.kr/", "00146012"), // 보성
            Map.entry("http://dylib.jne.go.kr/", "00146008"), // 담양
            Map.entry("http://ghlife.jne.go.kr/", "00146002"), // 고흥평생
            Map.entry("http://grlib.jne.go.kr/", "00146005"), // 구례
            Map.entry("http://gslib.jne.go.kr/", "00146003"), // 곡성
            Map.entry("http://gylib.jne.go.kr/", "00146025"), // 광양
            Map.entry("http://gylife.jne.go.kr/", "00146042"), // 광양평생
            Map.entry("http://hnlib.jne.go.kr/", "00146022"), // 해남
            Map.entry("http://hplib.jne.go.kr/", "00146021"), // 함평
            Map.entry("http://hslib.jne.go.kr/", "00146023"), // 화순
            Map.entry("http://jdlib.jne.go.kr/", "00146020"), // 진도
            Map.entry("http://jhlib.jne.go.kr/", "00146019"), // 장흥
            Map.entry("http://jsecc.jne.go.kr/", "00146059"), // 학생교육문화회관
            Map.entry("http://jslib.jne.go.kr/", "00146018"), // 장성
            Map.entry("http://malib.jne.go.kr/", "00146011"), // 무안
            Map.entry("http://mplib.jne.go.kr/", "00146010"), // 목포
            Map.entry("http://njlib.jne.go.kr/", "00146007"), // 나주
            Map.entry("http://nplib.jne.go.kr/", "00146006"), // 남평
            Map.entry("http://yalib.jne.go.kr/", "00146017"), // 영암
            Map.entry("http://yglib.jne.go.kr/", "00146016") // 영광
    );

    @Override
    public boolean supports(String homePage) {
        return homePage.contains(SUPPORTED_DOMAIN);
    }

    @Override
    public String getLibraryCode(String homePage) {
        return homePageAndCode.get(homePage);
    }

    @Override
    public String format(String homePage) {
        if(!homePageAndCode.containsKey(homePage))
            throw new IllegalArgumentException("지원하지 않는 홈페이지. homePageAndCode에 관련 데이터 추가 필요 => " + homePage);
        return COMMON_ISBN_PREFIX_FORMAT.formatted(homePageAndCode.get(homePage));
    }
}
