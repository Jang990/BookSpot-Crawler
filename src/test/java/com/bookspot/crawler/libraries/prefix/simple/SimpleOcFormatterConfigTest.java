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
    void 도봉구() {
        assertEquals(27, count(config.dobongUrlFormatter()));
    }

    @Test
    void 제주시_ISBN_미지원() {
        assertEquals(15, count(config.jejuUrlFormatter()));
    }

    @Test
    void 화성시립() {
        assertEquals(30, count(config.hscitylibUrlFormatter()));
    }

    @Test
    void 인천_서구() {
        assertEquals(6, count(config.isslUrlFormatter()));
    }

    @Test
    void 서울_중량() {
        assertEquals(6, count(config.jungnangUrlFormatter()));
    }

    @Test
    void 동대문구() {
        assertEquals(24, count(config.l4dUrlFormatter()));
    }

    @Test
    void 미추홀구() {
        assertEquals(6, count(config.michuhollUrlFormatter()));
    }

    @Test
    void 오산시() {
        assertEquals(7, count(config.osanUrlFormatter()));
    }

    @Test
    void 평창군립() {
        assertEquals(4, count(config.pcUrlFormatter()));
    }

    @Test
    void 대전서구_ISBN_검색미지원() {
        assertEquals(5, count(config.seoguUrlFormatter()));
    }

    @Test
    void 서산() {
        assertEquals(5, count(config.seosanUrlFormatter()));
    }

    @Test
    void 신립() {
        assertEquals(5, count(config.seosanUrlFormatter()));
    }

    @Test
    void 송파() {
        assertEquals(12, count(config.spUrlFormatter()));
    }

    @Test
    void 수원시립_도서관분류_불가능() {
        assertEquals(20, count(config.suwonlibUrlFormatter()));
    }

    @Test
    void 통영() {
        assertEquals(4, count(config.tongyeonglibUrlFormatter()));
    }

    @Test
    void 의정부() {
        assertEquals(6, count(config.uilibUrlFormatter()));
    }

    @Test
    void 울산_남구() {
        assertEquals(4, count(config.ulsannamguUrlFormatter()));
    }

    @Test
    void 의왕시() {
        assertEquals(12, count(config.uwlibUrlFormatter()));
    }

    @Test
    void 여주시() {
        assertEquals(8, count(config.yjlibUrlFormatter()));
    }

    @Test
    void 양평군_도서관_구분_불가능() {
        assertEquals(6, count(config.yplibUrlFormatter()));
    }

    @Test
    void 여수시립() {
        assertEquals(7, count(config.yeosuUrlFormatter()));
    }

    @Test
    void 광주광역시_존재해도_결과가_안나옴() {
        assertEquals(3, count(config.gwangjuUrlFormatter()));
    }

    @Test
    void 김제시립() {
        assertEquals(10, count(config.gimjeUrlFormatter()));
    }

    @Test
    void 광명시() {
        assertEquals(6, count(config.gmUrlFormatter()));
    }

    @Test
    void 안동시립() {
        assertEquals(3, count(config.andongUrlFormatter()));
    }

    @Test
    void 안양시립() {
        assertEquals(11, count(config.anyangUrlFormatter()));
    }

    @Test
    void 광주_북구_ISBN검색_미지원() {
        assertEquals(5, count(config.gwangjuBukguUrlFormatter()));
    }

    @Test
    void 창원() {
        assertEquals(3, count(config.changwonUrlFormatter()));
    }

    @Test
    void 대전_대덕_ISBN검색_미지원() {
        assertEquals(3, count(config.daedeokUrlFormatter()));
    }

    @Test
    void 동두천() {
        assertEquals(3, count(config.ddcUrlFormatter()));
    }

    @Test
    void 동작구() {
        assertEquals(9, count(config.dongjakUrlFormatter()));
    }

    @Test
    void 충북_음성군() {
        assertEquals(4, count(config.eumseongUrlFormatter()));
    }

    @Test
    void 거제시립() {
        assertEquals(12, count(config.geojeUrlFormatter()));
    }

    @Test
    void 광주시립() {
        assertEquals(11, count(config.gjcityUrlFormatter()));
    }

    @Test
    void 경기도교육청() {
        assertEquals(11, count(config.goeUrlFormatter()));
    }

    @Test
    void 구로() {
        assertEquals(9, count(config.guroUrlFormatter()));
    }

    @Test
    void 강원도_교육청() {
        assertEquals(22, count(config.gweUrlFormatter()));
    }

    @Test
    void 인천교육청() {
        assertEquals(9, count(config.iceUrlFormatter()));
    }

    @Test
    void 익산시립() {
        assertEquals(7, count(config.iksanUrlFormatter()));
    }

    @Test
    void 전북교육청_ISBN검색_미지원() {
        assertEquals(18, count(config.jbeUrlFormatter()));
    }

    @Test
    void 진천군립() {
        assertEquals(3, count(config.jincheonUrlFormatter()));
    }

    @Test
    void 논산() {
        assertEquals(3, count(config.nonsanUrlFormatter()));
    }

    @Test
    void 파주시립() {
        assertEquals(22, count(config.pajuUrlFormatter()));
    }

    @Test
    void 포천시() {
        assertEquals(7, count(config.pocheonUrlFormatter()));
    }

    @Test
    void 세종시() {
        assertEquals(15, count(config.sejongUrlFormatter()));
    }

    @Test
    void 시흥시() {
        assertEquals(12, count(config.siheungUrlFormatter()));
    }

    @Test
    void 울진군() {
        assertEquals(8, count(config.uljinUrlFormatter()));
    }

    @Test
    void sample() {
        assertEquals(20, count(config.UrlFormatter()));
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