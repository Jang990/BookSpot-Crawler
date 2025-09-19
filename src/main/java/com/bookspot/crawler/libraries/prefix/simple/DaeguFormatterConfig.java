package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class DaeguFormatterConfig {
    @Bean
    public IsbnSearchUrlFormatter daeguCommonUrlFormatter() {
        return new IsbnSearchUrlFormatter() {

            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain(
                        "daegu.go.kr/dalseolib",
                        "daegu.go.kr/beomeo",
                        "daegu.go.kr/bukgs",
                        "daegu.go.kr/buktj"
                );
            }

            @Override
            public Map<String, String> getLibraryNameAndCode() {
                return Map.ofEntries(
                        Map.entry("달서구립성서도서관", "BU"),
                        Map.entry("달서구립어린이도서관", "BV"),
                        Map.entry("달서구립도원도서관", "BW"),
                        Map.entry("달서구립본리도서관", "BX"),
                        Map.entry("달서구립가족문화도서관", "BY"),
                        Map.entry("달서구립달서영어도서관", "BZ"),
                        Map.entry("이곡2동 작은도서관", "FA"),
                        Map.entry("용산1동 작은도서관", "FB"),
                        Map.entry("장기동 작은도서관", "FC"),
                        Map.entry("죽전동 작은도서관", "FD"),
                        Map.entry("행정정보문고센터", "FX"),
                        Map.entry("학산 작은도서관", "GK"),

                        // 수성구립
                        Map.entry("수성구립책숲길도서관", "BJ"),
                        Map.entry("수성구립물망이도서관", "BK"),
                        Map.entry("수성구립범어도서관", "BD"),

                        // 북구
//                            Map.entry("대현도서관", "BB"),
//                            Map.entry("대구시청작은도서관", "FV"),
                        Map.entry("대구 북구 태전도서관", "BC"),
                        Map.entry("대구 북구 구수산도서관", "BA"),
                        Map.entry("서변숲도서관", "HW"),
                        Map.entry("산격1동 작은도서관", "GL"),
                        Map.entry("대구 북구 영어 작은도서관", "GM"),
                        Map.entry("침산1동 작은도서관", "GN"),
                        Map.entry("서변동 작은도서관", "HB"),
                        Map.entry("노원행복 작은도서관", "HD"),
                        Map.entry("한강공원부키 도서관", "HE")
                );
            }

            @Override
            public String format(LibraryPageDto dto) {
                if("노원동 작은도서관".equals(dto.name()))
                    return null;

                Matcher m = Pattern.compile("kr/([^/]+)").matcher(dto.homePage());
                if (!m.find())
                    throw new IllegalArgumentException(dto.toString());

                String region = m.group(1);
                return "https://library.daegu.go.kr/%s/intro/search/index.do?menu_idx=9&viewPage=1&booktype=BOOKANDNONBOOK&libraryCodes=%s&isbn="
                        .formatted(region, getLibraryCode(dto));
            }
        };
    }

    @Bean
    public IsbnSearchUrlFormatter daeguOthersUrlFormatter() {
        return new IsbnSearchUrlFormatter() {
            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain(
                        "daegu.go.kr/228",
                        "daegu.go.kr/bukbu",
                        "daegu.go.kr/duryu",
                        "daegu.go.kr/nambu",
                        "daegu.go.kr/seobu",
                        "daegu.go.kr/bukdh"
                );
            }

            @Override
            public String format(LibraryPageDto dto) {
                if (dto.name().equals("2.28도서관"))
                    return "https://library.daegu.go.kr/228lib/intro/search/index.do?menu_idx=125&viewPage=1&booktype=BOOKANDNONBOOK&isbn=";

                Matcher m = Pattern.compile("kr/([^/]+)").matcher(dto.homePage());
                if (m.find())
                    return "https://library.daegu.go.kr/%s/intro/search/index.do?menu_idx=13&viewPage=1&booktype=BOOKANDNONBOOK&isbn="
                            .formatted(m.group(1));
                throw new IllegalArgumentException(dto.toString());
            }
        };
    }

    @Bean
    public IsbnSearchUrlFormatter sample2UrlFormatter() {
        return new SimpleUrlFormatter(
                "daegu.go.kr/buktj"
        );
    }

    /*

    daegu.go.kr/dalseong
    daegu.go.kr/dalseongchild
    daegu.go.kr/dongbu
    daegu.go.kr/gosan
    daegu.go.kr/gw
    daegu.go.kr/junggu
    daegu.go.kr/namdm
    daegu.go.kr/namic
    daegu.go.kr/seogulib
    daegu.go.kr/suseong
    daegu.go.kr/yonghak
     */
}
