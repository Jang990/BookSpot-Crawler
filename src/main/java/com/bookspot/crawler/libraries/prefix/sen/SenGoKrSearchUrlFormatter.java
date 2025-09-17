package com.bookspot.crawler.libraries.prefix.sen;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.net.URI;
import java.net.URISyntaxException;

public class SenGoKrSearchUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String SUPPORTED_DOMAIN = "sen.go.kr";
    private static final String SUFFIX = "/intro/search/index.do?menu_idx=4&editMode=normal&search_text=";

    public boolean supports(LibraryPageDto dto) {
        return dto.homePage().contains(SUPPORTED_DOMAIN);
    }

    @Override
    public String getLibraryCode(LibraryPageDto dto) {
        return null;
    }

    @Override
    public String format(LibraryPageDto dto) {
        String homePage = dto.homePage();
        if (homePage == null || homePage.isBlank()) {
            throw new IllegalArgumentException("URL이 비어있음");
        }

        String u = homePage.trim();
        // scheme 없으면 기본 http://
        if (!u.matches("^[a-zA-Z][a-zA-Z0-9+.-]*://.*")) {
            u = "http://" + u;
        }

        try {
            URI uri = new URI(u);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (host == null || host.isBlank()) {
                throw new IllegalArgumentException("호스트를 추출할 수 없음: " + homePage);
            }

            // 첫 번째 라벨 추출
            String firstLabel = host.split("\\.")[0];

            // 기본 URL 끝에 / 붙이기
            String base = scheme + "://" + host;
            if (!base.endsWith("/")) {
                base += "/";
            }

            // 최종 URL: base + firstLabel + SUFFIX
            return base + firstLabel + SUFFIX;
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("잘못된 URL 형식: " + homePage, e);
        }
    }

}
