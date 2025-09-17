package com.bookspot.crawler.libraries.prefix;

import java.io.IOException;

public class UnsupportedSearchLibraryValidator implements IsbnUrlValidator {
    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        return true;
    }
}
