package com.bookspot.crawler.libraries.validator;

import java.io.IOException;

public class BclGoKrUrlValidator implements IsbnUrlValidator {
    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        // CSR 방식이라 검증이 어려움.
        return true;
    }
}
