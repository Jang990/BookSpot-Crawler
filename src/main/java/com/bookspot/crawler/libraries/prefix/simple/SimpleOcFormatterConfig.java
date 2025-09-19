package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class SimpleOcFormatterConfig {
    @Bean
    public IsbnSearchUrlFormatter ocUrlFormatter() {
//        https://lib.oc.go.kr/gnb03/lnb01/list.do?searchFlag=Y&pageUnit=30&manageCode=MA&isbn=9788936434120
        return new SimpleUrlFormatter(
                "oc.go.kr",
                "https://lib.oc.go.kr/gnb03/lnb01/list.do?searchFlag=Y&pageUnit=30&manageCode=%s&isbn=",
                Map.of("옥천군민도서관", "MA")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sdmUrlFormatter() {
//        https://lib.sdm.or.kr/sdmlib/menu/10003/program/30001/searchResultList.do?searchType=SIMPLE&viewType=LIST&searchDisplay=30&searchManageCodeArr=MA&searchKeyword=9788936434120
        return new SimpleUrlFormatter(
                "sdm.or.kr",
                "https://lib.sdm.or.kr/sdmlib/menu/10003/program/30001/searchResultList.do?searchType=SIMPLE&viewType=LIST&searchDisplay=30&searchManageCodeArr=%s&searchKeyword=",
                Map.ofEntries(
                        Map.entry("남가좌새롬어린이도서관", "MB"),
                        Map.entry("꿈이있는작은도서관", "SG"),
                        Map.entry("늘푸른열린작은도서관", "SM"),
                        Map.entry("문화촌작은도서관", "SH"),
                        Map.entry("아이누리작은도서관", "SE"),
                        Map.entry("홍은도담도서관", "MC"),
                        Map.entry("행복작은도서관", "SJ"),
                        Map.entry("햇살작은도서관", "SI"),
                        Map.entry("북아현마을 북카페", "SC"),
                        Map.entry("알음알음작은도서관", "SA"),
                        Map.entry("새싹작은도서관", "SF"),
                        Map.entry("서대문구립이진아기념도서관", "MA"),
                        Map.entry("파랑새작은도서관", "SK"),
                        Map.entry("하늘샘작은도서관", "SB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter seoulUrlFormatter() {
        return new SimpleUrlFormatter(
                "seoul.go.kr",
                "https://lib.seoul.go.kr/main/searchBrief?st=KWRD&si=TOTAL&sts=Y&lmt0=&searchType=&q="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sunchangUrlFormatter() {
        return new SimpleUrlFormatter(
                "sunchang.go.kr",
                "https://lib.sunchang.go.kr/keywordSearchResult/"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter wanjuUrlFormatter() {
        // https://lib.wanju.go.kr:8443/search/keyword/9788936434120?manageCode=MA 이러면 도서관별로 되긴하는데 현재 구조에선 불가능
        return new SimpleUrlFormatter(
                "wanju.go.kr",
                "https://lib.wanju.go.kr:8443/search/keyword/"
        );
    }

/*
    @Bean
    public IsbnSearchUrlFormatter UrlFormatter() {
        return new SimpleUrlFormatter(
                ""
        );
    }
*/

}
