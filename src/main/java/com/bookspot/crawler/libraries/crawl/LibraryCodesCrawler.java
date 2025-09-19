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

        System.out.println("=========> "+ count);
        for (int i = 1; i <= count; i++) {
            String targetLi = cssSelector + ":nth-child(%d)".formatted(i);
            String libraryName = result.findElementText(targetLi + "> Label");
            String code = result.findElementAttribute(targetLi + "> input", "value");
            System.out.println(escape(libraryName) + ", " + escape(code));
        }
    }

    public void crawlBusan(String url, String cssSelector) {
        CrawlingResult result = crawler.get(url);
        int count = result.countElements(cssSelector);

        for (int i = 1; i <= count; i++) {
            String targetLi = cssSelector + ":nth-child(%d)".formatted(i);
            String libraryName = result.findElementText(targetLi + "> a");
            String code = result.findElementAttribute(targetLi + "> a", "onclick")
                    .replace("countResultResearcher('", "").replace("')", "");
            System.out.println(escape(libraryName) + ", " + escape(code));
        }
    }

    private static String escape(String libraryName) {
        return "\"" + libraryName + "\"";
    }


}
