package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.ValidatorTestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaeguFormatterConfigTest {
    DaeguFormatterConfig config = new DaeguFormatterConfig();

    @Test
    void 대구_도서관() {
        assertEquals(57, ValidatorTestRunner.countRelatedLibrary(config.daeguCommonUrlFormatter()));
    }


    @Test
    void 대구_기타_도서관() {
        assertEquals(14, ValidatorTestRunner.countRelatedLibrary(config.daeguOthersUrlFormatter()));
    }


    @Test
    void sam() {
        long exists = count(config.daeguSampleUrlFormatter());

        long supported = count(config.daeguCommonUrlFormatter()) + count(config.daeguOthersUrlFormatter());

        assertEquals(exists, supported);
    }

    private long count(IsbnSearchUrlFormatter formatter) {
        return ValidatorTestRunner.countRelatedLibrary(formatter);
    }

}