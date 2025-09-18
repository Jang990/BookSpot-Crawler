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
            "http://eng.myclib.or.kr/", // 밀양시립영어도서관
            "www.busanlib.net" // (부산광역시 기장디지털도서관 - 대라다 도서관) 2개가 있는데 디지털 도서관만.
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
