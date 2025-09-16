package com.bookspot.crawler.libraries.formatter;

public interface IsbnSearchUrlFormatter {
    boolean supports(String homePage);
    String getLibraryCode(String homePage);
    String format(String homePage);
}
