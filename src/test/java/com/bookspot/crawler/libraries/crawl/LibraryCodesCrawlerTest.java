package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://kolas.cheonan.go.kr/search/index.php?mod=wdDataSearch&act=searchIList&serSec=detail&manageCode=DS&isbn=9788936434120",
                "#_multiChk1 > li"
        );
    }
}