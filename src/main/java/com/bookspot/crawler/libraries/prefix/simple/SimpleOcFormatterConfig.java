package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
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
    public IsbnSearchUrlFormatter geumsanUrlFormatter() {
        return new SimpleUrlFormatter(
                "geumsan.go.kr",
                "https://library.geumsan.go.kr:444/search/index.php?mod=wdDataSearch&deSearch=1&act=searchResultList&manageCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("금산작은도서관", "MC"),
                        Map.entry("금산인삼고을도서관", "MA"),
                        Map.entry("진산도서관", "MD"),
                        Map.entry("추부도서관", "MB"),
                        Map.entry("금산기적의도서관", "BR")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gyeongjuUrlFormatter() {
        return new SimpleUrlFormatter(
                "gyeongju.go.kr",
                "https://library.gyeongju.go.kr/?page_id=search_detailbooklist&mode=tDetailBookList&collection=tot_book&display_flag=2&searchKey5=SIB&limit_page=30&manage_code=%s&searchKeyword5=",
                Map.ofEntries(
                        Map.entry("경주시립송화도서관", "MG"),
                        Map.entry("경주시립감포도서관", "MB"),
                        Map.entry("경주시립단석도서관", "MC"),
                        Map.entry("경주시립도서관", "MA"),
                        Map.entry("경주시립중앙도서관", "MF"),
                        Map.entry("경주시립칠평도서관", "MD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yeoncheonUrlFormatter() {
        return new SimpleUrlFormatter(
                "yeoncheon.go.kr",
                "https://library.yeoncheon.go.kr/menu/10040/program/30006/searchResultList.do?searchType=DETAIL&searchCategory=ALL&searchLibrary=%s&searchIsbnIssn=",
                Map.ofEntries(
                        Map.entry("청산작은도서관", "ME"),
                        Map.entry("무등실작은도서관", "MF"),
                        Map.entry("연천도서관", "BR"),
                        Map.entry("연천군중앙도서관", "MA"),
                        Map.entry("학마을작은도서관", "MD"),
                        Map.entry("신서작은도서관", "MG")
                ),
                List.of("상리작은도서관")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter pohangUrlFormatter() {
        return new SimpleUrlFormatter(
                "pohang.go.kr",
                "https://phlib.pohang.go.kr/phlib/intro/search/index.do?menu_idx=297&booktype=BOOK&rowCount=30&libraryCodes=%s&search_text=",
                Map.ofEntries(
                        Map.entry("포항시립대잠도서관", "lib_MA"),
                        Map.entry("포항시립영암도서관", "lib_MC"),
                        Map.entry("신광면 비학산작은도서관", "lib_NE"),
                        Map.entry("송도동 솔향작은도서관", "lib_NS"),
                        Map.entry("장량동 햇살작은도서관", "lib_PD"),
                        Map.entry("장량동 해뜰참작은도서관", "lib_PL"),
                        Map.entry("상대동 큰섬마을작은도서관", "lib_NL"),
                        Map.entry("양학동 부학작은도서관", "lib_ND"),
                        Map.entry("연일읍 미르작은도서관", "lib_NM"),
                        Map.entry("오천읍 해와달작은도서관", "lib_NJ"),
                        Map.entry("용흥동 솔개재작은도서관", "lib_PJ"),
                        Map.entry("두호동 책이랑바다랑작은도서관", "lib_PG"),
                        Map.entry("두호동 두무치작은도서관", "lib_NF"),
                        Map.entry("대송면 큰솔작은도서관", "lib_NN"),
                        Map.entry("장량동 꿈마루작은도서관", "lib_PN"),
                        Map.entry("장량동 다솜작은도서관", "lib_PC"),
                        Map.entry("장량동 바람숲작은도서관", "lib_ZZ"),
                        Map.entry("장량동 참사랑작은도서관", "lib_NK"),
                        Map.entry("포항시립포은중앙도서관", "lib_MD"),
                        Map.entry("흥해읍 내맏이작은도서관", "lib_PH"),
                        Map.entry("죽장면 참느리작은도서관", "lib_PK"),
                        Map.entry("흥해읍 어리골작은도서관", "lib_PI"),
                        Map.entry("죽도동 청암작은도서관", "lib_NP"),
                        Map.entry("해도동 바다섬작은도서관", "lib_NC"),
                        Map.entry("청하면 해아작은도서관", "lib_PB"),
                        Map.entry("청림동 푸른숲작은도서관", "lib_NG"),
                        Map.entry("흥해읍 참새미작은도서관", "lib_PQ"),
                        Map.entry("구룡포 미르아라작은도서관", "lib_NZ"),
                        Map.entry("효곡동 행복작은도서관", "lib_NH"),
                        Map.entry("포항시립포은오천도서관", "lib_ME"),
                        Map.entry("기계면 버드내작은도서관", "lib_NV"),
                        Map.entry("효곡동 열린작은도서관", "lib_PE"),
                        Map.entry("효곡동 그린숲작은도서관", "lib_NQ"),
                        Map.entry("환여동 환호어린이작은도서관", "lib_NW"),
                        Map.entry("포항시립어린이영어도서관", "lib_PM"),
                        Map.entry("환여동 해맞이꿈터작은도서관", "lib_NU"),
                        Map.entry("포항시립동해석곡도서관", "lib_MF"),
                        Map.entry("포항시립구룡포도서관", "lib_MI"),
                        Map.entry("포항시립연일도서관", "lib_MH")

                ),
                List.of("죽도동 맑은물작은도서관", "청림동 찬내작은도서관")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter seocholibUrlFormatter() {
        return new SimpleUrlFormatter(
                "seocholib.or.kr",
                "https://public.seocholib.or.kr/KeywordSearchResult/"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter aplUrlFormatter() {
        return new SimpleUrlFormatter(
                "apl.go.kr",
                "https://www.anseong.go.kr/library/search/detailSearch.do?mId=0101010200&type=1&keywordCon5=A&keywordSel5=ISBN5&branchId=%s&keyword5=",
                Map.ofEntries(
                        Map.entry("안성삼죽작은도서관", "9"),
                        Map.entry("안성부영작은도서관", "5"),
                        Map.entry("안성송정작은도서관", "4"),
                        Map.entry("안성풍림작은도서관", "7"),
                        Map.entry("안성시 공도도서관", "10"),
                        Map.entry("안성죽산작은도서관", "6"),
                        Map.entry("안성시 진사도서관", "11"),
                        Map.entry("안성시 중앙도서관", "1"),
                        Map.entry("안성시 일죽도서관", "3"),
                        Map.entry("안성시 보개도서관", "2"),
                        Map.entry("안성태산작은도서관", "8")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sampleUrlFormatter() {
        return new SimpleUrlFormatter(
                "apl.go.kr"
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
