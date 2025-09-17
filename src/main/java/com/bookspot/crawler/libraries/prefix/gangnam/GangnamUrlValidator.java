package com.bookspot.crawler.libraries.prefix.gangnam;

import com.bookspot.crawler.libraries.crawl.common.CrawlingResult;
import com.bookspot.crawler.libraries.crawl.common.JsoupCrawler;
import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.IsbnUrlValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class GangnamUrlValidator implements IsbnUrlValidator {
    private final JsoupCrawler jsoupCrawler;

    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        if(prefix == null && targetSearchKind == null)
            return true;
        String url = prefix + targetSearchKind;
        CrawlingResult crawlingResult = jsoupCrawler.get(url);

        // 이동은 잘되지만 'ISBN:TB에 대한 검색결과 0건이 검색되었습니다. 이렇게 나온다.
//        String elementText = crawlingResult.findElementText("#searchForm > p");
//        log.trace("isbn13 포함 텍스트 | {}", elementText);
//        boolean hasIsbn13 = elementText.contains(expectedIsbn);
        boolean isSelectedLibraryCode = crawlingResult.findElementAttribute(
                "input[name=searchLibraryArr][checked]",
                "value").equals(targetSearchKind);

        log.trace("강남 검증 결과 | isSelectedLibraryCode={}", /*hasIsbn13,*/ isSelectedLibraryCode);

        return /*hasIsbn13 &&*/ isSelectedLibraryCode;
    }
}
