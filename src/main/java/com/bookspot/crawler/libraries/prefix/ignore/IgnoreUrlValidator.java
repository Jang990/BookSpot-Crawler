package com.bookspot.crawler.libraries.prefix.ignore;

import com.bookspot.crawler.libraries.prefix.IsbnUrlValidator;

import java.io.IOException;

public class IgnoreUrlValidator implements IsbnUrlValidator {

    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        if(prefix != null)
            throw new IllegalArgumentException("의미 있는 prefix를 받음 = " + prefix);
        return true;
    }
}
