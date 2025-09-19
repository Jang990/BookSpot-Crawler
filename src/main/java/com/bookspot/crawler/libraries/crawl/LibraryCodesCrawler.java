package com.bookspot.crawler.libraries.crawl;

import com.bookspot.crawler.libraries.crawl.common.CrawlingResult;
import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LibraryCodesCrawler {
    private final JsoupCrawler crawler;

    public void crawlLi(String url, String cssSelector) {
        CrawlingResult result = crawler.get(url);
        int count = result.countElements(cssSelector);

        for (int i = 1; i <= count; i++) {
            String targetLi = cssSelector + ":nth-child(%d)".formatted(i);
            String libraryName = result.findElementText(targetLi + "> Label");
            String code = result.findElementAttribute(targetLi + "> input", "value");
            System.out.println(escape(libraryName) + ", " + escape(code));
        }
    }

    private static String escape(String libraryName) {
        return "\"" + libraryName + "\"";
    }


    public record LibraryCode(String name, String code) { }
}
