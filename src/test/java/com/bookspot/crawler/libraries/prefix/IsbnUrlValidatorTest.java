package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.prefix.asan.AsanGoKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.asan.AsanGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.bcl.BclGoKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.bcl.BclGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.cne.CneUrlFormatter;
import com.bookspot.crawler.libraries.prefix.cne.CneUrlValidator;
import com.bookspot.crawler.libraries.prefix.daegu.dalseong.DalseongDaeguKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.daegu.dalseong.DalseongDaeguKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.gne.GneUrlFormatter;
import com.bookspot.crawler.libraries.prefix.gne.GneUrlValidator;
import com.bookspot.crawler.libraries.prefix.ignore.IgnoreIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.ignore.IgnoreUrlValidator;
import com.bookspot.crawler.libraries.prefix.jne.JneGoKrIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.jne.JneGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.sen.SenGoKrSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.sen.SenGoKrUrlValidator;
import org.junit.jupiter.api.Test;

class IsbnUrlValidatorTest {
    @Test
    void 도서관_검색을_지원하지_않는_홈페이지() {
        int expectedLibraryCnt = 20;
        ValidatorTestRunner.run(
                expectedLibraryCnt,
                new IgnoreIsbnSearchUrlFormatter(),
                new IgnoreUrlValidator()
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
    void 경상남도_ISBN검색_미지원() {
        ValidatorTestRunner.run(
                27,
                new GneUrlFormatter(),
                new GneUrlValidator()
        );
    }

    @Test
    void 대구_달성군_도서관_검색_미지원() {
        ValidatorTestRunner.run(
                8,
                new DalseongDaeguKrUrlFormatter(),
                new DalseongDaeguKrUrlValidator()
        );
    }

//    @Test
    void test() {
        ValidatorTestRunner.printRelatedLibrary(new GneUrlFormatter());
    }

}