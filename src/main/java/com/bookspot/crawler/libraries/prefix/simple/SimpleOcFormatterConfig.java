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
    public IsbnSearchUrlFormatter bpplUrlFormatter() {
        return new SimpleUrlFormatter(
                "bppl.or.kr",
                "https://www.bppl.or.kr/bugae/menu/10095/program/30031/searchResultList.do?searchType=DETAIL&searchCategory=ALL&searchKey5=ISBN&searchLibrary=%s&searchKeyword5=",
                Map.ofEntries(
                        Map.entry("부평구립부개도서관", "ME"),
                        Map.entry("부평구립부개어린이도서관", "MB"),
                        Map.entry("부평구립청천도서관", "MF"),
                        Map.entry("부평구립갈산도서관", "MC"),
                        Map.entry("부평기적의도서관", "MA"),
                        Map.entry("부평구립삼산도서관", "MD")
                )

        );
    }

    @Bean
    public IsbnSearchUrlFormatter dangjinUrlFormatter() {
        return new SimpleUrlFormatter(
                "dangjin.go.kr",
                "https://lib.dangjin.go.kr/dls_le/index.php?mod=wdDataSearch&act=searchIList&deSearch=1&serSec=detail&manageCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("고대웃음꽃 작은도서관", "BA"),
                        Map.entry("당진시립송악도서관", "MB"),
                        Map.entry("송악샘터 작은도서관", "BF"),
                        Map.entry("순성반딧불이 작은도서관", "BC"),
                        Map.entry("원당꿈초롱 작은도서관", "BE"),
                        Map.entry("송악해나루 작은도서관", "BG"),
                        Map.entry("석문생각나무 작은도서관", "BB"),
                        Map.entry("당진시립중앙도서관", "MA"),
                        Map.entry("대호지책나래 작은도서관", "BH"),
                        Map.entry("당진시립합덕도서관", "MC"),
                        Map.entry("신평책다솜 작은도서관", "BJ"),
                        Map.entry("송산개미 작은도서관", "BD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gbelibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gbelib.kr",
                "https://www.gbelib.kr/ad/intro/search/index.do?menu_idx=8&search_type=L_ISBN&sortField=DISP01&rowCount=30&libraryCodes=%s&search_text=",
                Map.ofEntries(
                        Map.entry("경상북도교육청정보센터", "00147046"),
                        Map.entry("경상북도교육청 구미도서관", "00147003"),
                        Map.entry("경상북도교육청 안동도서관", "00147010"),
                        Map.entry("경상북도교육청 안동도서관 용상분관", "00147011"),
                        Map.entry("경상북도교육청 안동도서관 풍산분관", "00147039"),
                        Map.entry("경상북도교육청 상주도서관", "00147008"),
                        Map.entry("경상북도교육청 상주도서관 화령분관", "00147040"),
                        Map.entry("경상북도교육청문화원 종합정보자료실", "00147105"),
                        Map.entry("경상북도교육청 영일도서관", "00147013"),
                        Map.entry("경상북도교육청 외동도서관", "00147016"),
                        Map.entry("경상북도교육청 영주선비도서관", "00147032"),
                        Map.entry("경상북도교육청 영주선비도서관 풍기분관", "00147024"), // 영주도서관 => 영주선비도서관 바꿈
                        Map.entry("경상북도교육청 금호도서관", "00147014"),
                        Map.entry("경상북도교육청 점촌도서관", "00147020"),
                        Map.entry("경상북도교육청 점촌도서관 가은분관", "00147006"),
                        Map.entry("경상북도교육청 의성도서관", "00147019"),
                        Map.entry("경상북도교육청 청송도서관", "00147022"),
                        Map.entry("경상북도교육청 영양도서관", "00147012"),
                        Map.entry("경상북도교육청 영덕도서관", "00147031"),
                        Map.entry("경상북도교육청 청도도서관", "00147021"),
                        Map.entry("경상북도교육청 고령도서관", "00147002"),
                        Map.entry("경상북도교육청 성주도서관", "00147009"),
                        Map.entry("경상북도교육청 칠곡도서관", "00147023"),
                        Map.entry("경상북도교육청 예천도서관", "00147015"),
                        Map.entry("경상북도교육청 봉화도서관", "00147007"),
                        Map.entry("경상북도교육청 울진도서관", "00147018"),
                        Map.entry("경상북도교육청 울릉도서관", "00147017"),
                        Map.entry("경상북도교육청 전자도서관", "00000001")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gclibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gclib.go.kr",
                "https://www.gclib.go.kr/lib/menu/10008/program/30001/searchResultList.do?searchType=SIMPLE&preSearchKeyword=9788936434120&searchDisplay=30&searchManageCodeArr=MA&searchKeyword=",
                Map.of("과천시정보과학도서관", "MA")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gdlibraryUrlFormatter() {
        return new SimpleUrlFormatter(
                "gdlibrary.or.kr",
                "https://www.gdlibrary.or.kr/portal/menu/38/book/search/collection?searchType=normal&smart_manage_code=&manage_code=%s&searchInput=",
                Map.ofEntries(
                        Map.entry("강동구립암사도서관", "MC"),
                        Map.entry("강동구립천호도서관", "MD"),
                        Map.entry("강동구립강일도서관", "MB"),
                        Map.entry("강동구립성내도서관", "MA"),
                        Map.entry("강동숲속도서관", "MF"),
                        Map.entry("강동중앙도서관", "MH"),
                        Map.entry("강동구립둔촌도서관", "ME"),
                        Map.entry("강동구립해공도서관", "BR")
                )

        );
    }

    @Bean
    public IsbnSearchUrlFormatter gimpoUrlFormatter() {
        return new SimpleUrlFormatter(
                "gimpo.go.kr",
                "https://www.gimpo.go.kr/janggi/bookSearchList.do?key=2780&rep=1&option=0&pageUnit=30&manageCode=%s&searchKrwd=",
                Map.ofEntries(
                        Map.entry("구래작은도서관", "GR"),
                        Map.entry("누리봄작은도서관", "BR"),
                        Map.entry("대곶작은도서관", "DK"),
                        Map.entry("통진도서관", "TJ"),
                        Map.entry("고촌도서관", "GC"),
                        Map.entry("양곡도서관", "YG"),
                        Map.entry("장기도서관", "JG"),
                        Map.entry("풍무도서관", "PM"),
                        Map.entry("마산도서관", "MS"),
                        Map.entry("모담도서관", "MD")
                ),
                List.of("중봉도서관") // TODO: 2025년까지 휴관
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gurilibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gurilib.go.kr",
                "https://www.gurilib.go.kr/inlib/menu/10018/program/30001/searchResultList.do?searchType=SIMPLE&searchPubFormCode=ALL&searchDisplay=30&searchManageCodeArr=%s&searchKeyword=",
                Map.ofEntries(
                        Map.entry("구리시립 교문방정환도서관", "BR"),
                        Map.entry("구리시립 인창도서관", "MA"),
                        Map.entry("구리시립 토평도서관", "TP")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gwangjinlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gwangjinlib.seoul.kr",
                "https://www.gwangjinlib.seoul.kr/gjinfo/menu/10037/program/30011/plusSearchResultList.do?searchType=DETAIL&searchCategory=ALL&searchKey5=ISBN&searchRecordCount=30&searchLibrary=%s&searchKeyword5=",
                Map.ofEntries(
                        Map.entry("광진정보도서관", "MA"),
                        Map.entry("자양한강도서관", "MF"),
                        Map.entry("구의제3동도서관", "MB"),
                        Map.entry("군자동도서관", "MG"),
                        Map.entry("아차산숲속도서관", "MH"),
                        Map.entry("자양제4동도서관", "MC"),
                        Map.entry("중곡문화체육센터도서관", "MD"),
                        Map.entry("광진어린이영어도서관", "MI"),
                        Map.entry("자양한강 스마트도서관", "NA"),
                        Map.entry("군자역 스마트도서관", "NB"),
                        Map.entry("구의역 스마트도서관", "ND"),
                        Map.entry("광진구민체육센터 스마트도서관", "NE")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter dobongUrlFormatter() {
        return new SimpleUrlFormatter(
                "unilib.dobong.kr",
                "https://www.unilib.dobong.kr/site/search/search00.do?cmd_name=bookandnonbooksearch&search_type=detail&manage_code=%s&search_txt=",
                Map.ofEntries(
                        Map.entry("도봉문화정보도서관", "MA"),
                        Map.entry("도봉아이나라도서관", "MB"),
                        Map.entry("도봉기적의도서관", "ME"),
                        Map.entry("쌍문채움도서관", "MG"),
                        Map.entry("원당마을한옥도서관", "MJ"),
                        Map.entry("둘리도서관", "MF"),
                        Map.entry("김근태기념도서관", "MH"),

                        Map.entry("도봉구청 행복작은도서관", "SA"),
                        Map.entry("도봉구립무수골도서관", "MD"),
                        Map.entry("김수영문학도서관", "SL"),
                        Map.entry("쌍문1동 공립 작은도서관", "SM"),
                        Map.entry("쌍문2동 공립 작은도서관", "SN"),
                        Map.entry("쌍문3동 공립 작은도서관", "SO"),
                        Map.entry("쌍문4동 공립 작은도서관", "SP"),
                        Map.entry("방학1동 공립 작은도서관", "SJ"),
                        Map.entry("방학2동 공립 작은도서관", "SK"),
                        Map.entry("창1동 공립 작은도서관", "SQ"),
                        Map.entry("창2동 공립 작은도서관", "SR"),
                        Map.entry("창3동 공립 작은도서관", "SS"),
                        Map.entry("창4동 공립 작은도서관", "ST"),
                        Map.entry("창5동 공립 작은도서관", "SU"),
                        Map.entry("도봉1동 공립 작은도서관", "SG"),
                        Map.entry("북서울중학교", "SC")
                ),
                List.of(
                        "방학동육아종합지원센터", // TODO: 있긴하다. https://doccic.go.kr/rental/center_01_book.php
                        "창동육아종합지원센터", // TODO: 있긴하다. https://doccic.go.kr/rental/center_02_book.php?pno=&mode=&sort=oi.regdate&sch_field=itemname&pagenumber=1&sch_age=&sch_bcode=&sch_value=9788936434120&listcnt=8
                        "도봉구립학마을도서관", // TODO: ~26년 2월까지 휴관
                        "지혜의등대 작은도서관", // TODO: 25.05~?? 휴관
                        "도봉2동 공립 작은도서관", // 안보임...
                        "방학3동 공립 작은도서관" // 안보임...
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jejuUrlFormatter() {
        return new SimpleUrlFormatter(
                "jeju.go.kr",
                "https://www.jeju.go.kr/lib/service/search/simple.htm?lib=%s&q=",
                Map.ofEntries(
                        Map.entry("한라도서관", "MJ"),
                        Map.entry("제주 우당도서관", "MK"),
                        Map.entry("제주 탐라도서관", "ML"),
                        Map.entry("제주기적의도서관", "MM"),
                        Map.entry("제주 애월도서관", "MP"),
                        Map.entry("제주 조천읍도서관", "MN"),
                        Map.entry("제주 한경도서관", "MQ"),
                        Map.entry("제주 삼매봉도서관", "MA"),
                        Map.entry("제주 중앙도서관", "MB"),
                        Map.entry("제주 동부도서관", "MC"),
                        Map.entry("제주 서부도서관", "MD"),
                        Map.entry("서귀포기적의도서관", "ME"),
                        Map.entry("제주 성산일출도서관", "MH"),
                        Map.entry("제주 안덕산방도서관", "MF"),
                        Map.entry("제주 표선도서관", "MG"),
                        Map.entry("제주 꿈바당어린이도서관", "XY")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter hscitylibUrlFormatter() {
        return new SimpleUrlFormatter(
                "hscitylib.or.kr",
                "https://www.hscitylib.or.kr/iutlib/menu/10684/program/30001/searchResultList.do?searchType=SIMPLE&searchDisplay=40&searchManageCodeArr=%s&searchKeyword=",
                Map.ofEntries(
                        Map.entry("화성시립남양도서관", "MA"),
                        Map.entry("화성시립태안도서관", "MB"),
                        Map.entry("화성시립삼괴도서관", "MC"),
                        Map.entry("화성시립병점도서관", "MD"),
                        Map.entry("화성시립봉담도서관", "MG"),
                        Map.entry("화성시립동탄복합문화센터도서관", "MK"),
                        Map.entry("화성시립송산도서관", "ML"),
                        Map.entry("화성시립정남도서관", "MM"),
                        Map.entry("화성시립진안도서관", "MO"),
                        Map.entry("화성시립왕배푸른숲도서관", "MW"),
                        Map.entry("화성시립노을빛도서관", "MX"),
                        Map.entry("화성시립향남복합문화센터도서관", "NA"),
                        Map.entry("화성시립동탄중앙이음터도서관", "MP"),
                        Map.entry("화성시립동탄다원이음터도서관", "MR"),
                        Map.entry("화성시립송린이음터도서관", "MS"),
                        Map.entry("화성시립두빛나래어린이도서관", "MF"),
                        Map.entry("화성시립동탄목동이음터도서관", "MI"),
                        Map.entry("화성시립서연이음터도서관", "MY"),
                        Map.entry("화성시립둥지나래어린이도서관", "MH"),
                        Map.entry("화성시립달빛나래어린이도서관", "TB"),
                        Map.entry("화성시립샘내작은도서관", "ME"),
                        Map.entry("화성시립기아행복마루작은도서관", "MJ"),
                        Map.entry("화성시립비봉작은도서관", "MN"),
                        Map.entry("화성시립마도작은도서관", "MU"),
                        Map.entry("화성시립팔탄작은도서관", "MT"),
                        Map.entry("화성시립양감작은도서관", "MQ"),
                        Map.entry("화성시립봉담커피앤북작은도서관", "MV"),
                        Map.entry("화성시립늘봄이음터작은도서관", "TA"),
                        Map.entry("화성시립호연이음터작은도서관", "MZ"),
                        Map.entry("화성시립서신작은도서관", "TC"),
                        Map.entry("화성시립가족만세센터도서관", "TD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter isslUrlFormatter() {
        return new SimpleUrlFormatter(
                "issl.go.kr",
                "https://www.issl.go.kr/sch/bsch/list.do?mnidx=1597&searchLibMngCd=%s&searchKeyword=",
                Map.ofEntries(
                        Map.entry("인천 서구 검단도서관", "MB"),
                        Map.entry("인천 서구 검암도서관", "MG"),
                        Map.entry("인천 서구 석남도서관", "MA"),
                        Map.entry("인천 서구 심곡도서관", "MD"),
                        Map.entry("인천 서구 신석도서관", "MF"),
                        Map.entry("인천 서구 단봉늘봄도서관", "MH")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jungnangUrlFormatter() {
        return new SimpleUrlFormatter(
                "jungnanglib.seoul.kr",
                "https://www.jungnanglib.seoul.kr/sblib/menu/10712/program/30001/searchResultList.do?searchType=SIMPLE&searchDisplay=30&searchManageCodeArr=%s&searchKeyword=",
                Map.ofEntries(
                        Map.entry("중화어린이도서관", "MC"),
                        Map.entry("중랑구립정보도서관", "MA"),
                        Map.entry("중랑구립면목정보도서관", "MB"),
                        Map.entry("중랑구립상봉도서관", "MF"),
                        Map.entry("중랑숲어린이도서관", "MD"),
                        Map.entry("중랑구립양원숲속도서관", "ME")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter l4dUrlFormatter() {
        return new SimpleUrlFormatter(
                "l4d.or.kr",
                "https://www.l4d.or.kr/intro/menu/10097/program/30011/plusSearchResultList.do?searchType=DETAIL&searchKey5=ISBN&searchRecordCount=30&searchLibrary=%s&searchKeyword5=",
                Map.ofEntries(
                        Map.entry("동대문구정보화도서관", "MA"),
                        Map.entry("동대문구답십리도서관", "MF"),
                        Map.entry("배봉산 숲속도서관", "SP"),
                        Map.entry("동대문책마당도서관", "SN"),
                        Map.entry("휘경행복도서관", "MM"),
                        Map.entry("제기동감초마을 현진건기념도서관", "MN"),
                        Map.entry("장안어린이도서관", "MB"),
                        Map.entry("용두어린이영어도서관", "MC"),
                        Map.entry("휘경어린이도서관", "MJ"),
                        Map.entry("이문어린이도서관", "ME"),
                        Map.entry("이문체육문화센터 어린이도서관", "MD"),
                        Map.entry("전곡마을 작은도서관", "MG"),
                        Map.entry("장안 가온누리 작은도서관", "MH"),
                        Map.entry("동대문구 장안 벚꽃길 작은도서관", "MI"),
                        Map.entry("전농2동 뜨락 작은도서관", "SM"),
                        Map.entry("답십리1동 아름드리 작은도서관", "SI"),
                        Map.entry("답십리2동 민들레 작은도서관", "SL"),
                        Map.entry("장안1동 작은도서관", "SF"),
                        Map.entry("휘경1동 새싹마루 작은도서관", "SK"),
                        Map.entry("휘경2동 꿈빛누리 작은도서관", "SH"),
                        Map.entry("이문1동 꿈꾸는 작은도서관", "SJ"),
                        Map.entry("이문2동 작은도서관", "SA"),
                        Map.entry("장안마루 작은도서관", "SO"),
                        Map.entry("장안꿈마루어린이 작은도서관", "SQ"),
                        Map.entry("용두어울림작은도서관", "SR"),
                        Map.entry("답십리역스마트도서관", "ML"),
                        Map.entry("용두역스마트도서관", "MK")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter michuhollUrlFormatter() {
        return new SimpleUrlFormatter(
                "michuhollib.go.kr",
                "https://www.michuhollib.go.kr/itg/sch/bsch/list.do?mnidx=385&searchLibMngCd=%s&searchKeyword=",
                Map.ofEntries(
                        Map.entry("송도국제기구도서관", "MB"),
                        Map.entry("청라호수도서관", "ME"),
                        Map.entry("마전도서관", "MF"),
                        Map.entry("영종하늘도서관", "MC"),
                        Map.entry("청라국제도서관", "MD"),
                        Map.entry("미추홀도서관", "MA"),
                        Map.entry("인천시청 행정자료실", "MG")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sampleUrlFormatter() {
        return new SimpleUrlFormatter(
                "michuhollib.go.kr"
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
