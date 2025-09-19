package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.ValidatorTestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaeguFormatterConfigTest {
    DaeguFormatterConfig config = new DaeguFormatterConfig();

    @Test
    void 대구_도서관() {
        assertEquals(24, ValidatorTestRunner.countRelatedLibrary(config.daeguCommonUrlFormatter()));
    }


    @Test
    void 대구_기타_도서관() {
        assertEquals(7, ValidatorTestRunner.countRelatedLibrary(config.daeguOthersUrlFormatter()));
    }

    @Test
    void sample() {
        ValidatorTestRunner.countRelatedLibrary(config.sample2UrlFormatter());
    }

}