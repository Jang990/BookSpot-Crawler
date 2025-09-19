package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.ValidatorTestRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleOcFormatterConfigTest {
    SimpleOcFormatterConfig config = new SimpleOcFormatterConfig();

    @Test
    void 옥천군_도서관() {
        assertEquals(1, ValidatorTestRunner.countRelatedLibrary(config.ocUrlFormatter()));
    }

    @Test
    void 서대문구_도서관() {
        assertEquals(14, ValidatorTestRunner.countRelatedLibrary(config.sdmUrlFormatter()));
    }

    @Test
    void 서울도서관_단일() {
        ValidatorTestRunner.countRelatedLibrary(config.seoulUrlFormatter());
    }

/*
    @Test
    void t() {
        ValidatorTestRunner.countRelatedLibrary(config.sdmUrlFormatter());
    }
*/



}