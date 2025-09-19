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

    @Bean
    public IsbnSearchUrlFormatter wonjuUrlFormatter() {
        return new SimpleUrlFormatter(
                "wonju.go.kr",
                "https://lib.wonju.go.kr/ja/menu/234/book/search?search=true&searchType=normal&size=30&searchCondition=searchTxt&facetLibrary=%s&searchInput=",
                Map.ofEntries(
                        Map.entry("원주시립중앙도서관", "MA"),
                        Map.entry("원주시립미리내도서관", "MQ"),
                        Map.entry("원주시립샘마루도서관", "MS"),
                        Map.entry("원주시립태장도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yangsanUrlFormatter() {
        return new SimpleUrlFormatter(
                "yangsan.go.kr",
                "https://lib.yangsan.go.kr/YS/search/search.do?display=30&book_type=BOOK&search_type=normal&search_manage_code=%s&search_txt=",
                Map.ofEntries(
                        Map.entry("양산시립 중앙도서관", "MA"),
                        Map.entry("양산시립 웅상도서관", "MB"),
                        Map.entry("물구나무작은도서관", "FC"),
                        Map.entry("양산시립 윤현진도서관", "MH"),
                        Map.entry("양산시립 상북도서관", "MD"),
                        Map.entry("원동작은도서관", "GF"),
                        Map.entry("순지작은도서관", "FS"),
                        Map.entry("양산시립 영어도서관", "MC"),
                        Map.entry("양산시립 서창도서관", "ME")
                )
        );
    }

    // https://lib.yongin.go.kr/yongin/menu/10182/program/30013/plusSearchResultList.do?searchType=DETAIL&searchCategory=BOOK&searchRoom=ALL&searchRecordCount=30&searchLibrary=MA&searchKey5=ISBN&searchKeyword5=9788936434120
    @Bean
    public IsbnSearchUrlFormatter yonginUrlFormatter() {
        return new SimpleUrlFormatter(
                "yongin.go.kr",
                "https://lib.yongin.go.kr/yongin/menu/10182/program/30013/plusSearchResultList.do?searchType=DETAIL&searchCategory=BOOK&searchRoom=ALL&searchRecordCount=30&searchLibrary=%s&searchKey5=ISBN&searchKeyword5=",
                Map.ofEntries(
                        Map.entry("보라도서관", "MM"),
                        Map.entry("청덕도서관", "MP"),
                        Map.entry("동백도서관", "MF"),
                        Map.entry("기흥도서관", "MK"),
                        Map.entry("구갈희망누리도서관", "MI"),
                        Map.entry("구성도서관", "MD"),
                        Map.entry("양지해밀도서관", "MJ"),
                        Map.entry("흥덕도서관", "MN"),
                        Map.entry("이동꿈틀도서관", "MX"),
                        Map.entry("죽전도서관", "ME"),
                        Map.entry("모현도서관", "ML"),
                        Map.entry("포곡도서관", "MC"),
                        Map.entry("상현도서관", "MO"),
                        Map.entry("수지도서관", "MB"),
                        Map.entry("용인중앙도서관", "MA"),
                        Map.entry("남사도서관", "MY"),
                        Map.entry("성복도서관", "NB"),
                        Map.entry("서농도서관", "MZ")
                )
        );
    }

    // https://kolas.cheonan.go.kr/search/index.php?mod=wdDataSearch&act=searchIList&serSec=detail&manageCode=DS&isbn=9788936434120
    @Bean
    public IsbnSearchUrlFormatter cheonanUrlFormatter() {
        return new SimpleUrlFormatter(
                "cheonan.go.kr",
                "https://kolas.cheonan.go.kr/search/index.php?mod=wdDataSearch&act=searchIList&serSec=detail&manageCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("천안시아우내도서관", "BC"),
                        Map.entry("천안시성거도서관", "BR"),
                        Map.entry("천안시두정도서관", "DJ"),
                        Map.entry("천안시도솔도서관", "DS"),
                        Map.entry("천안시중앙도서관", "MA"),
                        Map.entry("천안시신방도서관", "SC"),
                        Map.entry("천안시쌍용도서관", "SY"),
                        Map.entry("천안시청수도서관", "CS")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter geochangUrlFormatter() {
        return new SimpleUrlFormatter(
                "geochang.go.kr",
                "https://library.geochang.go.kr/lib/book_search/search_list.asp" + "?"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sampleUrlFormatter() {
        return new SimpleUrlFormatter(
                "geumjeong.go.kr"
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
