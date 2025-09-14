package com.bookspot.crawler.libraries;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JneGoKrUrlValidatorTest {
    JneGoKrUrlValidator validator = new JneGoKrUrlValidator();

    @Test
    void test() throws IOException {
        assertTrue(
                validator.checkSearchPage(
                        "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=00146012&vSrchText0=",
                        "9788936434120", "00146012"
                )
        );
        assertTrue(
                validator.checkSearchPage(
                        "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=00146013&vSrchText0=",
                        "9788936434120", "00146013"
                )
        );
    }

}