package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GunsanUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gunsan.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.of(
                "군산시립도서관", "MA",
                "군산시립늘푸른도서관", "SB",
                "군산시립설림도서관", "SS",
                "군산시립임피채만식도서관", "BR",
                "군산시립산들도서관", "OG",
                "군산시립금강도서관", "KG"
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.gunsan.go.kr/web/menu/10004/program/30002/searchResultList.do?searchType=ADVANCED&searchManageCodeArr=%s&searchAdvIsbn=";
    }
}
