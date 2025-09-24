package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

@Component
public class GangseoUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gangseo.seoul.kr");
    }

    @Override
    public String getTemplate() {
        return "https://lib.gangseo.seoul.kr/KeywordSearchResult/";
    }
}
