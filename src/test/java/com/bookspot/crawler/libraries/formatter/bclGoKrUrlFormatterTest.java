package com.bookspot.crawler.libraries.formatter;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class bclGoKrUrlFormatterTest {
    BclGoKrUrlFormatter formatter = new BclGoKrUrlFormatter();

    @Test
    void CSR방식이라_전부_같은_prefix반환() {
        assertEquals(
                "https://alpasq.bcl.go.kr/search/keyword/",
                formatter.format(new LibraryPageDto(null, "부천행정정보도서관 시정담벼락", "http://bcsl.go.kr/"))
        );

        assertEquals(
                "https://alpasq.bcl.go.kr/search/keyword/",
                formatter.format(new LibraryPageDto(null, "부천시립상동도서관", "http://www.bcl.go.kr/"))
        );

        assertEquals(
                "https://alpasq.bcl.go.kr/search/keyword/",
                formatter.format(new LibraryPageDto(null, "소새울가족작은도서관", "https://www.bcl.go.kr"))
        );
    }

}