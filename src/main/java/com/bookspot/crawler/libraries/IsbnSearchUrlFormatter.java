package com.bookspot.crawler.libraries;

public interface IsbnSearchUrlFormatter {
    boolean supports(String homePage);
    String format(String homePage);
}
