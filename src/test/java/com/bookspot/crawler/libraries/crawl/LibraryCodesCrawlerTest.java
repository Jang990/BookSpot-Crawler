package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import org.junit.jupiter.api.Test;

class LibraryCodesCrawlerTest {
    LibraryCodesCrawler crawler = new LibraryCodesCrawler(new JsoupCrawler());

    @Test
    void test() {
        crawler.crawlLi(
                "https://library.daegu.go.kr/bukgs/intro/search/index.do?menu_idx=9&viewPage=1&separateShelfCode=&facet_manage_code=&facet_author=&facet_publisher=&facet_pub_year=&facet_subject_code=&facet_media_code=&reSearchTitle=&reSearchAuthor=&reSearchPubler=&reSearchKeyword=&title=&libraryCodes=BA&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&_libraryCodes=on&author=&publer=&keyword=&search_start_date=&search_end_date=&subjectCode=&isbn=9788936434120&booktype=BOOKANDNONBOOK&shelfCode=&media_code=&sortField=NONE&sortType=ASC&rowCount=10#search_result",
                "#libraryList > div:nth-child(2) > ul > li"
        );
    }
}