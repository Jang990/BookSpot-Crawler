package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://library.daegu.go.kr/dalseolib/intro/search/index.do?menu_idx=9&viewPage=1&booktype=BOOKANDNONBOOK&libraryCodes=BU&isbn=9788936434120#search_result",
                "#libraryList > div:nth-child(2) > ul > li"
        );
    }
}