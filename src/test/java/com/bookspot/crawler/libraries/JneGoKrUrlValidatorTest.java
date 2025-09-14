package com.bookspot.crawler.libraries;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JneGoKrUrlValidatorTest {
    Map<String, String> homePageAndCode = JneGoKrIsbnSearchUrlFormatter.homePageAndCode;
    JneGoKrIsbnSearchUrlFormatter formatter = new JneGoKrIsbnSearchUrlFormatter();
    JneGoKrUrlValidator validator = new JneGoKrUrlValidator();
    private String expectedIsbn13 = "9788936434120";

    @Test
    void test() throws IOException {
        for (String homePage : homePageAndCode.keySet()) {
            String prefix = formatter.format(homePage);
            String code = homePageAndCode.get(homePage);
            validator.checkSearchPage(prefix, expectedIsbn13, code);
        }
    }

}