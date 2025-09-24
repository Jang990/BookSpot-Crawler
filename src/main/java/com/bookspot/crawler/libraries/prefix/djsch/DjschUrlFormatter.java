package com.bookspot.crawler.libraries.prefix.djsch;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DjschUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN = "djsch.kr";
    private static Map<String, String> map = Map.of(
            "http://dsecc.djsch.kr", "https://dsecc.djsch.kr/djsecc/cm/cntnts/ifeView.do?pNum=010102&mi=1104",
            "http://sslib.djsch.kr/sanseong/main.do", "https://sslib.djsch.kr/sanseong/cm/cntnts/ifeView.do?pNum=010102&mi=1165"
    );

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain(DOMAIN);
    }

    @Override
    public String format(LibraryPageDto dto) {
        return map.get(dto.homePage()) + "&";
    }
}
