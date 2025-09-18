package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class GumiUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gumi.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("구미시립상모정수도서관", "ME"),
                Map.entry("구미시립봉곡도서관", "MD"),
                Map.entry("구미시립선산도서관", "MC"),
                Map.entry("구미시립인동도서관", "MB"),
                Map.entry("구미시립중앙도서관", "MA"),
                Map.entry("한국폴리텍대학구미캠퍼스작은도서관", "BA"),
                Map.entry("구미시립양포도서관", "MG"),
                Map.entry("구미생활문화센터작은도서관", "BA"),
                Map.entry("평생학습원 자료실", "BA"),
                Map.entry("구미시립산동도서관", "MH"),
                Map.entry("송정나래작은도서관", "BA"),
                Map.entry("구미시립작은도서관", "BA"),
                Map.entry("해평누리작은도서관", "BA")
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.gumi.go.kr/dls_lt/index.php?act=searchResultList&manageCode=%s&isbn=";
    }
}
