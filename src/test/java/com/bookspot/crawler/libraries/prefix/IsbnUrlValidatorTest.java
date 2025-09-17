package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.prefix.asan.AsanGoKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.asan.AsanGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.bcl.BclGoKrUrlFormatter;
import com.bookspot.crawler.libraries.prefix.bcl.BclGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.jne.JneGoKrIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.jne.JneGoKrUrlValidator;
import com.bookspot.crawler.libraries.prefix.sen.SenGoKrSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.sen.SenGoKrUrlValidator;
import org.junit.jupiter.api.Test;

class IsbnUrlValidatorTest {
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

}