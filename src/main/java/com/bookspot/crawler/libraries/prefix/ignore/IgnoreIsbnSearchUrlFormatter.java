package com.bookspot.crawler.libraries.prefix.ignore;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.List;

public class IgnoreIsbnSearchUrlFormatter implements IsbnSearchUrlFormatter {
    public static List<String> WHITE_LIST = List.of(
            "agjlib.gangnam.go.kr",
            "cafe.daum.net/ddmbook",
            "http://iw1lib.gangnam.go.kr/", // 일원1동작은도서관
            "http://suseolib.gangnam.go.kr/", // 수서동작은도서관
            "https://library.gangnam.go.kr/", // 일원2동문고
            "gbeti.or.kr", // 경상북도교육청연수원
            "www.dhildfund-deagu.or.kr", // 대구 동구 초록우산 도서관
            "www.dscf.or.kr", // 대구 달서구 아트센터 도서관
            "blog.naver.com/nongollibrary" // 논골작은도서관 - 성남시 도서관이랑 다른 서울 서대문구 쪽 도서관임
    );

    @Override
    public String[] getDomains() {
        return null;
    }

    @Override
    public boolean supports(LibraryPageDto dto) {
        if(dto.homePage() == null
                || dto.homePage().equals("")
                || dto.homePage().equals("-"))
            return true;

        return WHITE_LIST.contains(dto.homePage());
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    @Override
    public String format(LibraryPageDto dto) {
        return null;
    }
}
