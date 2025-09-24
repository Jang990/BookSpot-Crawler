package com.bookspot.crawler.libraries.prefix.icheon;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class IcheonUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("icheonlib.go.kr");
    }

    @Override
    public String format(LibraryPageDto dto) {
        return "https://www.icheonlib.go.kr/search/tot" + "?";
    }
}
