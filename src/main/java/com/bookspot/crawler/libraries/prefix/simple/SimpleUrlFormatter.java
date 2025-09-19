package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class SimpleUrlFormatter implements IsbnSearchUrlFormatter {
    private final String domain;
    private final Map<String, String> map;
    private final String template;

    public SimpleUrlFormatter(String domain) {
        this.domain = domain;
        this.map = null;
        this.template = null;
    }

    public SimpleUrlFormatter(String domain, String template) {
        this.domain = domain;
        this.template = template;
        this.map = null;
    }


    public SimpleUrlFormatter(String domain, String template, Map<String, String> map) {
        this.domain = domain;
        this.template = template;
        this.map = map;
    }

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain(domain);
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return map;
    }

    @Override
    public String getTemplate() {
        return template;
    }
}
