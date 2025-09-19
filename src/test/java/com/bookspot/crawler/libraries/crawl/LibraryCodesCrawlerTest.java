package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://www.unilib.dobong.kr/site/search/search00.do?cmd_name=bookandnonbooksearch&search_type=detail&manage_code=MA%2CMB%2CME%2CMG%2CMJ%2CMF%2CMH%2CSA%2CMD%2CSL%2CSM%2CSN%2CSO%2CSP%2CSJ%2CSK%2CSQ%2CSR%2CSS%2CST%2CSU%2CSG%2CSC&search_txt=9788936434120",
                "#ul_small_lib2 > li"
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