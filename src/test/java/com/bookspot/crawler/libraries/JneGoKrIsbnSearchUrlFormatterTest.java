package com.bookspot.crawler.libraries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JneGoKrIsbnSearchUrlFormatterTest {
    JneGoKrIsbnSearchUrlFormatter formatter = new JneGoKrIsbnSearchUrlFormatter();

    @Test
    void test() {
        assertEquals(
                "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=00146013&vSrchText0=",
                formatter.format("http://bglib.jne.go.kr/")
        );

        assertEquals(
                "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=00146012&vSrchText0=",
                formatter.format("http://bslib.jne.go.kr/")
        );
    }

}