package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class UlsanJungguUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("junggu.ulsan.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("약숫골도서관", "MA"),
                Map.entry("학성도서관", "MH"),
                Map.entry("산전만화도서관", "MJ"),
                Map.entry("우정도서관", "MG"),
                Map.entry("태화루도서관", "MC"),
                Map.entry("함월도서관", "MB"),
                Map.entry("옥골샘도서관", "MD"),
                Map.entry("남외어린이도서관", "ML"),
                Map.entry("외솔한옥도서관", "MF"),
                Map.entry("울산종갓집도서관", "MM")
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.junggu.ulsan.kr/lib/unit/search/list.do?mId=001003001000000000&display=50&search_type=detail&book_type=ALL&manage_code=%s&search_isbn_issn=";
    }
}
