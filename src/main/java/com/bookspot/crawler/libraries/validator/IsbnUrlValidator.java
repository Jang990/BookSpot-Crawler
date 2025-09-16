package com.bookspot.crawler.libraries.validator;

import java.io.IOException;

public interface IsbnUrlValidator {
    boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException;
}
