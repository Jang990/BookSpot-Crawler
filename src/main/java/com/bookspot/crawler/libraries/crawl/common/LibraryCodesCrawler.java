package com.bookspot.crawler.libraries.crawl.common;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class LibraryCodesCrawler {
    private final JsoupCrawler crawler;

    private static final String NAME_SELECTOR = "#sh_util03 > div > div:nth-child(2) > ol > li:nth-child(%d) > label";
    private static final String CODE_SELECTOR = "#sh_util03 > div > div:nth-child(2) > ol > li:nth-child(%d) > input";

    public List<LibraryCode> crawl() {
        CrawlingResult result = crawler.get("https://www.eplib.or.kr/unified/search.asp");

        List<LibraryCode> list = new ArrayList<>();
        for (int i = 1; i <= 19; i++) {
            String name = result.findElementText(NAME_SELECTOR.formatted(i));
            String code = result.findElementText(CODE_SELECTOR.formatted(i));
            System.out.println(name + " " + code);
            list.add(new LibraryCode(name, code));
        }
        return list;
    }


    public record LibraryCode(String name, String code) { }
}
