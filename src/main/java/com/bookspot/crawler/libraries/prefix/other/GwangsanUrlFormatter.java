package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GwangsanUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gwangsan.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.of(
                "광산구립이야기꽃도서관", "MB",
                "광산구립장덕도서관", "JM",
                "광산구립운남어린이도서관", "WN",
                "광산구립신가도서관", "BR",
                "광산구립첨단도서관", "MA"
        );
    }

    @Override
    public String getTemplate() {
        return "https://lib.gwangsan.go.kr/main/bookSearch?query=&libCodeArr=%s" + "&";
    }
}
