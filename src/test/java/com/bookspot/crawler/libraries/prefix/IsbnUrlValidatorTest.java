package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import com.bookspot.crawler.libraries.prefix.other.*;
import com.bookspot.crawler.libraries.prefix.asan.AsanGoKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.asan.AsanGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.bcl.BclGoKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.bcl.BclGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.cne.CneUrlFormatter;
import com.bookspot.crawler.libraries.prefix.cne.CneUrlValidator;
import com.bookspot.crawler.libraries.prefix.daegu.dalseong.DalseongDaeguKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.daegu.dalseong.DalseongDaeguKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.djsch.DjschUrlFormatter;
import com.bookspot.crawler.libraries.prefix.donghae.DongHaeUrlFormatter;
import com.bookspot.crawler.libraries.prefix.gangnam.GangnamUrlFormatter;
import com.bookspot.crawler.libraries.prefix.gangnam.GangnamUrlValidator;
import com.bookspot.crawler.libraries.prefix.geumcheon.GeumcheonUrlFormatter;
import com.bookspot.crawler.libraries.prefix.gne.GneUrlFormatter;
import com.bookspot.crawler.libraries.prefix.gne.GneUrlValidator;
import com.bookspot.crawler.libraries.prefix.icheon.IcheonUrlFormatter;
import com.bookspot.crawler.libraries.prefix.ignore.IgnoreIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.ignore.OnlyTrueValidator;
import com.bookspot.crawler.libraries.prefix.jne.JneGoKrIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.jne.JneGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.sen.SenGoKrSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.sen.SenGoKrUrlValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsbnUrlValidatorTest {
    JsoupCrawler crawler = new JsoupCrawler();

    @Test
    void 도서관_검색을_지원하지_않는_홈페이지() {
        assertEquals(
                21,
                ValidatorTestRunner.countRelatedLibrary(new IgnoreIsbnSearchUrlFormatter())
        );
    }

    @Test
    void 전라남도_도서관_검증() {
        int expectedLibraryCnt = 21;
        ValidatorTestRunner.run(
                expectedLibraryCnt,
                new JneGoKrIsbnSearchUrlFormatter(),
                new JneGoKrUrlValidator()
        );
    }

    @Test
    void 서울_도서관_검증() {
        int expectedLibraryCnt = 23;
        ValidatorTestRunner.run(
                expectedLibraryCnt,
                new SenGoKrSearchUrlFormatter(),
                new SenGoKrUrlValidator()
        );
    }

    @Test
    void 아산_도서관_검증() {
        int expectedLibraryCnt = 7;
        ValidatorTestRunner.run(
                expectedLibraryCnt,
                new AsanGoKrUrlFormatter(),
                new AsanGoKrUrlValidator()
        );
    }

    @Test
    void 부천_도서관_검증__CSR이라_전부_동일_URL() {
        int expectedLibraryCnt = 38;
        ValidatorTestRunner.run(
                expectedLibraryCnt,
                new BclGoKrUrlFormatter(),
                new BclGoKrUrlValidator()
        );
    }

    @Test
    void 충청남도() {
        int expectedLibraryCnt = 19;
        ValidatorTestRunner.run(
                expectedLibraryCnt,
                new CneUrlFormatter(),
                new CneUrlValidator()
        );
    }

    @Test
    void 경상남도_교육청_ISBN검색_미지원() {
        ValidatorTestRunner.run(
                27,
                new GneUrlFormatter(),
                new GneUrlValidator()
        );
    }

    @Test
    void 대구_달성군_도서관() {
        ValidatorTestRunner.run(
                9,
                new DalseongDaeguKrUrlFormatter(),
                new DalseongDaeguKrUrlValidator()
        );
    }

    @Test
    void 강남도서관_일부_검색_미지원() {
        ValidatorTestRunner.run(
                26,
                new GangnamUrlFormatter(),
                new GangnamUrlValidator(crawler)
        );
    }

    @Test
    void 동해도서관() {
        ValidatorTestRunner.run(
                6,
                new DongHaeUrlFormatter(),
                new OnlyTrueValidator()
        );
    }

    @Test
    void 대전학생교육_ISBN검색_미지원() {
        ValidatorTestRunner.run(
                2,
                new DjschUrlFormatter(),
                new OnlyTrueValidator()
        );
    }

    @Test
    void 금천도서관() {
        ValidatorTestRunner.run(
                4,
                new GeumcheonUrlFormatter(),
                new OnlyTrueValidator()
        );
    }

    @Test
    void 충청북도_ISBN검색_미지원() {
        ValidatorTestRunner.run(
                15,
                new ChungBukFormatter(),
                new OnlyTrueValidator()
        );
    }

    @Test
    void 은평구_ISBN검색은_지원하나_CSR방식() {
        assertEquals(
                18,
                ValidatorTestRunner.countRelatedLibrary(new EunpyeongFormatter())
        );
    }

    @Test
    void 이천시_ISBN검색_미지원() {
        assertEquals(
                15,
                ValidatorTestRunner.countRelatedLibrary(new IcheonUrlFormatter())
        );
    }



    @Test
    void 안산시_도서관_선택_불가능() {
        assertEquals(
                27,
                ValidatorTestRunner.countRelatedLibrary(new AnsanUrlFormatter())
        );
    }

    @Test
    void 동구_ISBN검색_미지원() {
        assertEquals(
                8,
                ValidatorTestRunner.countRelatedLibrary(new DongguUrlFormatter())
        );
    }

    @Test
    void 강서_도서관_선택_불가능() {
        ValidatorTestRunner.countRelatedLibrary(new GangseoUrlFormatter());
    }

    @Test
    void 경산_도서관_ISBN검색_도서관_선택_불가능() {
        assertEquals(
                2,
                ValidatorTestRunner.countRelatedLibrary(new GbgsUrlFormatter())
        );
    }

    @Test
    void 광주교육청도서관() {
        assertEquals(
                6,
                ValidatorTestRunner.countRelatedLibrary(new GenUrlFormatter())
        );
    }

    @Test
    void 김해시_ISBN검색이_있으나_검색어_없으면_동작안함() {
        assertEquals(
                45,
                ValidatorTestRunner.countRelatedLibrary(new GimhaeUrlFormatter())
        );
    }

    @Test
    void 다산도서관() {
        assertEquals(
                1,
                ValidatorTestRunner.countRelatedLibrary(new GoryeongUrlFormatter())
        );
    }

    @Test
    void 구미시립도서관() {
        assertEquals(
          13,
                ValidatorTestRunner.countRelatedLibrary(new GumiUrlFormatter())
        );
    }

    @Test
    void 군산시립도서관() {
        assertEquals(
                6,
                ValidatorTestRunner.countRelatedLibrary(new GunsanUrlFormatter())
        );
    }

    @Test
    void 관악구도서관() {
        assertEquals(
                8,
                ValidatorTestRunner.countRelatedLibrary(new GwanakUrlFormatter())
        );
    }

    @Test
    void 광양시립도서관() {
        assertEquals(
                6,
                ValidatorTestRunner.countRelatedLibrary(new GwangyangUrlFormatter())
        );
    }

    @Test
    void 제주도서관_DB점검중() {
        assertEquals(
                15,
                ValidatorTestRunner.countRelatedLibrary(new JejuUrlFormatter())
        );
    }

    @Test
    void 전주도서관() {
        assertEquals(
                12,
                ValidatorTestRunner.countRelatedLibrary(new JeonjuUrlFormatter())
        );
    }

    @Test
    void 진주시립도서관() {
        assertEquals(
                7,
                ValidatorTestRunner.countRelatedLibrary(new JinjuUrlFormatter())
        );
    }

    @Test
    void 울산중구_구립도서관() {
        assertEquals(
                10,
                ValidatorTestRunner.countRelatedLibrary(new UlsanJungguUrlFormatter())
        );
    }

    @Test
    void 광주남구_도서관__ISBN검색_미지원() {
        assertEquals(
                3,
                ValidatorTestRunner.countRelatedLibrary(new GwangjuNamguUrlFormatter())
        );
    }

    @Test
    void 남양주_도서관() {
        assertEquals(
                13,
                ValidatorTestRunner.countRelatedLibrary(new NyjUrlFormatter())
        );
    }

/*
    @Test
    void template() {
        ValidatorTestRunner.countRelatedLibrary(new GwangyangUrlFormatter());
    }
*/

}