package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://www.gbelib.kr/ad/intro/search/index.do?menu_idx=8&search_type=L_ISBN&search_text=9788936434120&libraryCodes=00147010&sortField=DISP01&rowCount=30",
                "#libraryList > div:nth-child(2) > ul > li"
        );
    }

    @Test
    void testBusan() {
        crawler.crawlBusan(
                "http://one-library.busan.go.kr/busanbooks/?mode=tBookList&page_id=result&mapflag=&manage_code=&search_title=%ED%95%9C%EA%B0%95&search_author=&search_publisher=&search_keyword=&search_start_date=&search_end_date=",
                "#search_detail > div:nth-child(1) > div > ul > li"
        );
    }
}