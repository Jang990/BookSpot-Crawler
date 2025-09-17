package com.bookspot.crawler.libraries.prefix.gne;

import com.bookspot.crawler.libraries.prefix.IsbnUrlValidator;

import java.io.IOException;

public class GneUrlValidator implements IsbnUrlValidator {
    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        return prefix.endsWith("&")
                && prefix.substring(prefix.lastIndexOf("=") + 1).length() == 13;
    }
}
