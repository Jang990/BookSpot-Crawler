package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://www.l4d.or.kr/intro/menu/10097/program/30011/plusSearchResultList.do?searchType=DETAIL&searchCategory=ALL&searchKey1=TITLE&searchKeyword1=&searchOperator1=AND&searchKey2=AUTHOR&searchKeyword2=&searchOperator2=AND&searchKey3=PUBLISHER&searchKeyword3=&searchOperator3=AND&searchKey4=KEYWORD&searchKeyword4=&searchOperator4=AND&searchKey6=REG_NO&searchKeyword6=&searchOperator6=AND&searchKey5=ISBN&searchKeyword5=9788936434120&searchOperator5=AND&searchSeparateShelfCode=&searchPublishStartYear=&searchPublishEndYear=&searchLibrary=MM&searchRoom=ALL&searchSort=KEY&searchOrder=DESC&searchRecordCount=10",
                "#searchForm > div.searchCheckBox.mt10 > div > ul > li"
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