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
        assertEquals(1, ValidatorTestRunner.countRelatedLibrary(config.seoulUrlFormatter()));
    }

    @Test
    void 순창군도서관_단일_도서관선택_미지원() {
        assertEquals(1, ValidatorTestRunner.countRelatedLibrary(config.sunchangUrlFormatter()));
    }

    @Test
    void 완주군립_도서관_도서관선택을_지원하나_맨뒤에_두는_방식이라_불가능() {
        assertEquals(5, ValidatorTestRunner.countRelatedLibrary(config.wanjuUrlFormatter()));
    }

    @Test
    void 원주시립_도서관() {
        assertEquals(4, ValidatorTestRunner.countRelatedLibrary(config.wonjuUrlFormatter()));
    }

    @Test
    void 양산시립_도서관() {
        assertEquals(9, ValidatorTestRunner.countRelatedLibrary(config.yangsanUrlFormatter()));
    }

    @Test
    void 용인_도서관() {
        assertEquals(
                18,
                ValidatorTestRunner.countRelatedLibrary(config.yonginUrlFormatter())
        );
    }

    @Test
    void 천안시_도서관() {
        assertEquals(
                8,
                ValidatorTestRunner.countRelatedLibrary(config.cheonanUrlFormatter())
        );
    }

    @Test
    void 부산_남구_도서관_ISBN검색_미지원() {
        assertEquals(
                2,
                ValidatorTestRunner.countRelatedLibrary(config.bsnamguUrlFormatter())
        );
    }


/*
    @Test
    void t() {
        ValidatorTestRunner.countRelatedLibrary(config.sdmUrlFormatter());
    }
*/



}