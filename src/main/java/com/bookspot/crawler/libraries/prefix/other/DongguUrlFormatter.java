package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

@Component
public class DongguUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("donggu.go.kr");
    }

    @Override
    public String format(LibraryPageDto dto) {
        return "https://www.donggu.go.kr/dg/lib/contents/907" + "?";
    }
}
