package com.bookspot.crawler.libraries.crawl.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

//    @Test
    void test() {
        crawler.crawl();
    }
}