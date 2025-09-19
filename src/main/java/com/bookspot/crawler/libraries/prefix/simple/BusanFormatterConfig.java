package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class BusanFormatterConfig {
    @Bean
    public IsbnSearchUrlFormatter commonBusanUrlFormatter() {
        return new IsbnSearchUrlFormatter() {
            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain(
                        "bsnamgu.go.kr"
                );
            }

            @Override
            public Map<String, String> getLibraryNameAndCode() {
                return Map.ofEntries(
                        Map.entry("부산광역시 분포도서관","JT"),
                        Map.entry("부산광역시 남구도서관","AQ")
                );
            }

            @Override
            public String getTemplate() {
                return "http://one-library.busan.go.kr/busanbooks/?mode=tBookList&page_id=result&manage_code=%s&search_title=" + "&";
            }
        };
    }
}
