package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EunpyeongFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toMultiDomain(
            "eplib.or.kr", // ...
                "www.jsplib.or.kr", // 구립증산정보도서관
                "www.ealib.or.kr", // 구립응암정보도서관
                "www.enlib.or.kr", // 구립은평뉴타운도서관
                "www.gsvlib.or.kr", // 구립구산동도서관마을
                "www.nslib.or.kr", // 구립내를건너서숲으로도서관
                "www.edlib.or.kr", // 구립은뜨락도서관
                "sscc.or.kr", // 신사어린이도서관
                "blog.naver.com/djkkumnam", // 대조꿈나무어린이도서관
                "edu.eunpyeong.go.kr" // 은평어린이영어도서관
        );
    }

    @Override
    public String format(LibraryPageDto dto) {
        // CSR 방식이라 URL로 변경 불가능
        return "https://www.eplib.or.kr/unified/search.asp" + "?";
    }
}
