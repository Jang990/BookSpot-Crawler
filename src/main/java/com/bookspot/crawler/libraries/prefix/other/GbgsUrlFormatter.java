package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

public class GbgsUrlFormatter implements IsbnSearchUrlFormatter {
    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gbgs.go.kr");
    }

    @Override
    public String getTemplate() {
        return "https://www.gbgs.go.kr/lib/kolas/search.tc?mn=1053&pageSeq=587" + "&";
    }
}
