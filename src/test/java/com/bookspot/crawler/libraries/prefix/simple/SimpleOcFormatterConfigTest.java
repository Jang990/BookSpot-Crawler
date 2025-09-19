package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.ValidatorTestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleOcFormatterConfigTest {
    SimpleOcFormatterConfig config = new SimpleOcFormatterConfig();

    @Test
    void 옥천군_도서관() {
        assertEquals(1, count(config.ocUrlFormatter()));
    }

    @Test
    void 서대문구_도서관() {
        assertEquals(14, count(config.sdmUrlFormatter()));
    }

    @Test
    void 서울도서관_단일() {
        assertEquals(1, count(config.seoulUrlFormatter()));
    }

    @Test
    void 순창군도서관_단일_도서관선택_미지원() {
        assertEquals(1, count(config.sunchangUrlFormatter()));
    }

    @Test
    void 완주군립_도서관_도서관선택을_지원하나_맨뒤에_두는_방식이라_불가능() {
        assertEquals(5, count(config.wanjuUrlFormatter()));
    }

    @Test
    void 원주시립_도서관() {
        assertEquals(4, count(config.wonjuUrlFormatter()));
    }

    @Test
    void 양산시립_도서관() {
        assertEquals(9, count(config.yangsanUrlFormatter()));
    }

    @Test
    void 용인_도서관() {
        assertEquals(
                18,
                count(config.yonginUrlFormatter())
        );
    }

    @Test
    void 천안시_도서관() {
        assertEquals(
                8,
                count(config.cheonanUrlFormatter())
        );
    }

    @Test
    void 부산_남구_도서관_ISBN검색_미지원() {
        assertEquals(
                2,
                count(config.bsnamguUrlFormatter())
        );
    }

    @Test
    void 거창군립_도서관_ISBN미지원_단일도서관() {
        assertEquals(
                1,
                count(config.geochangUrlFormatter())
        );
    }

    @Test
    void sample() {
        count(config.sampleUrlFormatter());
    }

    private long count(IsbnSearchUrlFormatter formatter) {
        return ValidatorTestRunner.countRelatedLibrary(formatter);
    }


/*
    @Test
    void t() {
        ValidatorTestRunner.countRelatedLibrary(config.sdmUrlFormatter());
    }
*/



}