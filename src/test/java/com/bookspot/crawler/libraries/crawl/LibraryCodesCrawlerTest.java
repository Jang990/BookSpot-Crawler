package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://lib.sejong.go.kr/main/site/search/bookSearch.do?cmd_name=bookandnonbooksearch&search_type=detail&search_isbn_issn=9788936434120&manage_code=MQ#detail",
                "#frm_sch > fieldset > div > div.total_list_box > dl > dd > div.part2 > dl > dd > ul > li"
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