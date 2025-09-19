package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://lib.yongin.go.kr/yongin/menu/10181/program/30012/plusSearchSimple.do",
                "#searchForm > div > div.searchLibArea > div.searchLibWrap > div.box_checkWrap > div > ul > li"
        );
    }
}