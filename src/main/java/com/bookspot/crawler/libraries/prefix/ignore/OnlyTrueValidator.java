package com.bookspot.crawler.libraries.prefix.ignore;

import com.bookspot.crawler.libraries.prefix.IsbnUrlValidator;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OnlyTrueValidator implements IsbnUrlValidator {
    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        return true;
    }
}
