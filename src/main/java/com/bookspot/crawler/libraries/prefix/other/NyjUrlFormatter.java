package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class NyjUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("nyj.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("남양주시 별빛도서관", "141568"),
                Map.entry("남양주시 별내도서관", "141137"),
                Map.entry("남양주시 화도도서관", "141071"),
                Map.entry("남양주시 진건도서관", "141091"),
                Map.entry("남양주시 진접도서관", "141521"),
                Map.entry("남양주시 진접푸른숲도서관", "141536"),
                Map.entry("남양주시 오남도서관", "141176"),
                Map.entry("남양주시 평내도서관", "141175"),
                Map.entry("남양주시 퇴계원도서관", "141401"),
                Map.entry("남양주시 와부도서관", "141146"),
                Map.entry("남양주시 호평도서관", "141265"),
                Map.entry("남양주시 정약용도서관", "141035"),
                Map.entry("남양주시 이석영뉴미디어도서관", "141625")
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.nyj.go.kr/bbit/menu/11072/program/30018/plusSearchResultList.do?searchType=DETAIL&searchKey5=ISBN&searchLibrary=%s&searchRecordCount=30&searchKeyword5=";
    }
}
