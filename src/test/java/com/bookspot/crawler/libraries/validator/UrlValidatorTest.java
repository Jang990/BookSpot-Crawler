package com.bookspot.crawler.libraries.validator;

import com.bookspot.crawler.libraries.formatter.JneGoKrIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.formatter.SenGoKrSearchUrlFormatter;
import org.junit.jupiter.api.Test;

class UrlValidatorTest {
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

}