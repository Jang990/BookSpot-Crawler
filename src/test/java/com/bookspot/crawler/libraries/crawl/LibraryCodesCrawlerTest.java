package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://library.daegu.go.kr/dalseonglib/intro/search/index.do?menu_idx=9&booktype=BOOKANDNONBOOK&title=9788936434120#search_result",
                "#libraryList > div:nth-child(2) > ul > li"
        );
    }

    @Test
    void testBusan() {
        crawler.crawlBusan(
                "http://one-library.busan.go.kr/busanbooks/?mode=tBookList&page_id=result&mapflag=&manage_code=&search_title=%ED%95%9C%EA%B0%95&search_author=&search_publisher=&search_keyword=&search_start_date=&search_end_date=",
                "#searchForm > div.searchWrap > div.searchBotarea > div.box_checkWrap > ul > li:nth-child(2) > dl > dd > ol > li"
        );
    }
}