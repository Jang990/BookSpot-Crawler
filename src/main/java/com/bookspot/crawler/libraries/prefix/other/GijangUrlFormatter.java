package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class GijangUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toMultiDomain(
                "gijang.go.kr",
                "www.busanlib.net"
        );
    }

    @Override
    public boolean supports(LibraryPageDto dto) {
        if(dto.homePage().contains("gijang.go.kr"))
            return true;
        if(dto.homePage().contains("www.busanlib.net") && "부산광역시 대라다목적도서관".equals(dto.name()))
            return true;
        return false;
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
            Map.entry("부산광역시 정관도서관", "jglib"),
            Map.entry("부산광역시 기장도서관", "gijang"),
            Map.entry("부산광역시 고촌어울림도서관", "gochon"),
            Map.entry("부산광역시 교리도서관", "gyori"),
            Map.entry("부산광역시 정관어린이도서관", "jgchildlib"),
            Map.entry("부산광역시 내리새라도서관", "naeri"),
            Map.entry("부산광역시 대라다목적도서관", "daera")
        );
    }

    @Override
    public String getTemplate() {
        return "https://jglib.gijang.go.kr/portal/kolas/book/search.do?mId=1000000000&pageno=1&display=50&libraryPath=%s&search_txt=";
    }
}
