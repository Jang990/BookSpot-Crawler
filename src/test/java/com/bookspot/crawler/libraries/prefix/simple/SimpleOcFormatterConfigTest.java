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
    void 거창군립_도서관_ISBN미지원_단일도서관() {
        assertEquals(
                1,
                count(config.geochangUrlFormatter())
        );
    }

    @Test
    void 금산군() {
        assertEquals(5, count(config.geumsanUrlFormatter()));
    }

    @Test
    void 경주시립() {
        assertEquals(6, count(config.gyeongjuUrlFormatter()));
    }

    @Test
    void 연천군() {
        assertEquals(7, count(config.yeoncheonUrlFormatter()));
    }

    @Test
    void 포항() {
        assertEquals(41, count(config.pohangUrlFormatter()));
    }

    @Test
    void 서초구_도서관_선택_불가() {
        assertEquals(23, count(config.seocholibUrlFormatter()));
    }

    @Test
    void 안성시() {
        assertEquals(11, count(config.aplUrlFormatter()));
    }


    @Test
    void 인천_부평() {
        assertEquals(6, count(config.bpplUrlFormatter()));
    }

    @Test
    void 당진시립() {
        assertEquals(12, count(config.dangjinUrlFormatter()));
    }

    @Test
    void 경상북도() {
        assertEquals(27, count(config.gbelibUrlFormatter()));
    }

    @Test
    void 과천시정보과학도서관_단일() {
        assertEquals(1, count(config.gclibUrlFormatter()));
    }

    @Test
    void 강동구() {
        assertEquals(8, count(config.gdlibraryUrlFormatter()));
    }

    @Test
    void 김포() {
        assertEquals(11, count(config.gimpoUrlFormatter()));
    }

    @Test
    void 구리시립() {
        assertEquals(3, count(config.gurilibUrlFormatter()));
    }

    @Test
    void 서울_광진() {
        assertEquals(8, count(config.gwangjinlibUrlFormatter()));
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