package com.bookspot.crawler.libraries.prefix.gangnam;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.List;
import java.util.Map;

public class GangnamUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOAMIN = "gangnam.go.kr";
    private static final List<String> unsupportedSearchLibraryNames = List.of(
            "http://iw1lib.gangnam.go.kr/", // 일원1동작은도서관
            "http://suseolib.gangnam.go.kr/", // 수서동작은도서관
            "https://library.gangnam.go.kr/" // 일원2동문고
    );

    private static final Map<String, String> libNameAndCode = Map.ofEntries(
            Map.entry("압구정동문고","TB"),
            Map.entry("도곡2동작은도서관", "TC"),
            Map.entry("개포4동작은도서관", "TD"),
            Map.entry("일원본동작은도서관", "TE"),
            Map.entry("신사동작은도서관", "TA"),
            Map.entry("강남구립청담도서관", "MK"),
            Map.entry("대치1동작은도서관", "SB"),
            Map.entry("강남구립대치도서관", "MC"),
            Map.entry("강남구립도곡정보문화도서관", "MA"),
            Map.entry("강남구립일원라온영어도서관", "SH"),
            Map.entry("강남구립행복한도서관", "ML"),
            Map.entry("강남구립못골한옥어린이도서관", "ME"),
            Map.entry("강남구립개포하늘꿈도서관", "MM"),
            Map.entry("강남구립정다운도서관", "MI"),
            Map.entry("강남구립즐거운도서관", "MJ"),
            Map.entry("강남구립못골도서관", "MD"),
            Map.entry("논현문화마루도서관(분관)", "SA"),
            Map.entry("강남구립논현도서관", "MB"),
            Map.entry("강남구립논현문화마루도서관", "MN"),
            Map.entry("세곡마루도서관", "SF"),
            Map.entry("세곡도서관", "SD"),
            Map.entry("삼성도서관", "SC"),
            Map.entry("강남구립열린도서관", "MH"),
            Map.entry("역삼2동작은도서관", "SE"),
            Map.entry("강남구립역삼도서관", "MF"),
            Map.entry("강남구립역삼푸른솔도서관", "MG")
    );

    @Override
    public boolean supports(LibraryPageDto dto) {
        return dto.homePage().contains(DOAMIN);
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        String result = libNameAndCode.get(dto.name());
        if(result == null)
            return null;
        return result;
    }

    @Override
    public String format(LibraryPageDto dto) {
        if(unsupportedSearchLibraryNames.contains(dto.homePage()))
            return null;

        String libraryCode = getLibraryCode(dto);
        if(libraryCode == null)
            throw new IllegalArgumentException(dto.toString());
        return "https://library.gangnam.go.kr/yllib/menu/10671/program/30002/plusSearchResultList.do?searchType=DETAIL&searchRecordCount=50&searchLibrary=%s&searchKey5=ISBN&searchKeyword5="
                .formatted(libraryCode);
    }
}
