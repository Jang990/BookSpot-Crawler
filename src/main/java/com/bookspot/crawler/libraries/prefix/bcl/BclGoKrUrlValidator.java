package com.bookspot.crawler.libraries.prefix.bcl;

import com.bookspot.crawler.libraries.prefix.IsbnUrlValidator;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BclGoKrUrlValidator implements IsbnUrlValidator {
    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        // CSR 방식이라 검증이 어려움.
        return true;
    }
}
