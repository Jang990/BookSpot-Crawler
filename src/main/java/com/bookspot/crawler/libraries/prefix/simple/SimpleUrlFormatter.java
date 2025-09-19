package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.List;
import java.util.Map;

public class SimpleUrlFormatter implements IsbnSearchUrlFormatter {
    private final String domain;
    private final Map<String, String> map;
    private final String template;
    private final List<String> nullNamesList;

    public SimpleUrlFormatter(String domain) {
        this.domain = domain;
        this.map = null;
        this.template = null;
        nullNamesList = List.of();
    }

    public SimpleUrlFormatter(String domain, String template) {
        this.domain = domain;
        this.template = template;
        this.map = null;
        nullNamesList = List.of();
    }


    public SimpleUrlFormatter(String domain, String template, Map<String, String> map) {
        this.domain = domain;
        this.template = template;
        this.map = map;
        nullNamesList = List.of();
    }

    public SimpleUrlFormatter(String domain, String template, Map<String, String> map, List<String> nullNamesList) {
        this.domain = domain;
        this.map = map;
        this.template = template;
        this.nullNamesList = nullNamesList;
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

    @Override
    public String format(LibraryPageDto dto) {
        if(nullNamesList.contains(dto.name()))
            return null;
        return IsbnSearchUrlFormatter.super.format(dto);
    }
}
