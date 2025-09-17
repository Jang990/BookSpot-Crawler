package com.bookspot.crawler.libraries.prefix.ignore;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IgnoreIsbnSearchUrlFormatterTest {
    IgnoreIsbnSearchUrlFormatter formatter = new IgnoreIsbnSearchUrlFormatter();

    @ParameterizedTest
    @ValueSource(strings = {"", "-", "http://agjlib.gangnam.go.kr/", "http://cafe.daum.net/ddmbook"})
    void test(String homePage) {
        assertNull(
                formatter.format(new LibraryPageDto(null, null, homePage))
        );
    }
}