package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class GwanakUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gwanak.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.of(
                "관악중앙도서관", "MA",
                "은천동작은도서관", "KE",
                "낙성대공원도서관", "G3",
                "글빛정보도서관", "KJ",
                "조원도서관", "KW",
                "고맙습니다 하난곡작은도서관", "G4",
                "용꿈꾸는작은도서관", "L5",
                "성현동작은도서관", "KP"
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.gwanak.go.kr/galib/menu/10004/program/30002/searchResultList.do?searchType=DETAIL&searchRecordCount=50&searchLibraryArr=%s&searchKey5=ISBN&searchKeyword5=";
    }
}
