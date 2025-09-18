package com.bookspot.crawler.libraries.prefix.daegu.dalseong;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.UnsupportedSearchLibraryFormatter;

public class DalseongDaeguKrUrlFormatter extends UnsupportedSearchLibraryFormatter {
    private static final String DOMAIN = "dalseong.daegu.kr";

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain(DOMAIN);
    }
}
