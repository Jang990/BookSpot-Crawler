package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

@Component
public class GoryeongUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("goryeong.go.kr");
    }

    @Override
    public String getTemplate() {
        // 단일 도서관
        return "http://lib.goryeong.go.kr/book/bookCommon.do?jspFile=ownBooksSearch&searchLibCode=" + "&";
    }
}
