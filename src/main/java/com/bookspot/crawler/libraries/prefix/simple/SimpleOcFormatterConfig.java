package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
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
                "https://lib.yongin.go.kr/yongin/menu/10182/program/30013/plusSearchResultList.do" + queryString_searchKeyword5(),
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
                "https://kolas.cheonan.go.kr/search/index.php" + queryString_wdDataSearch(),
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
        return new IsbnSearchUrlFormatter() {
            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain("apl.go.kr", "anseong.go.kr");
            }

            @Override
            public String getTemplate() {
                return "https://www.anseong.go.kr/library/search/detailSearch.do?mId=0101010200&type=1&keywordCon5=A&keywordSel5=ISBN5&branchId=%s&keyword5=";
            }

            @Override
            public Map<String, String> getLibraryNameAndCode() {
                return Map.ofEntries(
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
                        Map.entry("안성태산작은도서관", "8"),
                        Map.entry("안성시 아양도서관", "13"),
                        Map.entry("안성대림동산작은도서관", "12")
                );
            }
        };
    }

    @Bean
    public IsbnSearchUrlFormatter bpplUrlFormatter() {
        return new SimpleUrlFormatter(
                "bppl.or.kr",
                "https://www.bppl.or.kr/bugae/menu/10095/program/30031/searchResultList.do" + queryString_searchKeyword5(),
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
                "https://www.gwangjinlib.seoul.kr/gjinfo/menu/10037/program/30011/plusSearchResultList.do" + queryString_searchKeyword5(),
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
        return new IsbnSearchUrlFormatter() {
            List<String> nullNameList = List.of(
                    "방학동육아종합지원센터", // TODO: 있긴하다. https://doccic.go.kr/rental/center_01_book.php
                    "창동육아종합지원센터", // TODO: 있긴하다. https://doccic.go.kr/rental/center_02_book.php?pno=&mode=&sort=oi.regdate&sch_field=itemname&pagenumber=1&sch_age=&sch_bcode=&sch_value=9788936434120&listcnt=8
                    "도봉구립학마을도서관", // TODO: ~26년 2월까지 휴관
                    "지혜의등대 작은도서관", // TODO: 25.05~?? 휴관
                    "도봉2동 공립 작은도서관", // 안보임...
                    "방학3동 공립 작은도서관" // 안보임...
            );

            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain("unilib.dobong.kr", "https://geuntae.co.kr");
            }

            @Override
            public String getTemplate() {
                return "https://www.unilib.dobong.kr/site/search/search00.do?cmd_name=bookandnonbooksearch&search_type=detail&manage_code=%s&search_txt=";
            }

            @Override
            public Map<String, String> getLibraryNameAndCode() {
                return Map.ofEntries(
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
                );
            }

            @Override
            public String format(LibraryPageDto dto) {
                if(nullNameList.contains(dto.name()))
                    return null;
                return IsbnSearchUrlFormatter.super.format(dto);
            }
        };
    }

    @Bean
    public IsbnSearchUrlFormatter jejuUrlFormatter() {
        return new IsbnSearchUrlFormatter() {
            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain(
                        "jeju.go.kr",
                        "jjdreamlib.or.kr" // 제주 꿈바당어린이도서관
                );
            }

            @Override
            public String getTemplate() {
                return "https://www.jeju.go.kr/lib/service/search/simple.htm?lib=%s&q=";
            }

            @Override
            public Map<String, String> getLibraryNameAndCode() {
                return Map.ofEntries(
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
                );
            }
        };
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
                "https://www.l4d.or.kr/intro/menu/10097/program/30011/plusSearchResultList.do" + queryString_searchKeyword5(),
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
    public IsbnSearchUrlFormatter osanUrlFormatter() {
        return new SimpleUrlFormatter(
                "osanlibrary.go.kr",
                "https://www.osanlibrary.go.kr/jungang/menu/10108/program/30005/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("오산시 중앙도서관", "MA"),
                        Map.entry("오산시 꿈두레도서관", "MG"),
                        Map.entry("오산시 양산도서관", "MD"),
                        Map.entry("오산시 청학도서관", "MB"),
                        Map.entry("오산시 초평도서관", "ME"),
                        Map.entry("오산시 소리울도서관", "MI"),
                        Map.entry("오산시 햇살마루도서관", "MC"),
                        Map.entry("오산시 무지개도서관", "MY"),
                        Map.entry("오산시 고현초꿈키움도서관", "MH"),
                        Map.entry("오산시 쌍용예가시민개방도서관", "MJ")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter pcUrlFormatter() {
        return new SimpleUrlFormatter(
                ".pc.go.kr",
                "https://www.pc.go.kr/lib/main/site/search/bookSearch.do" + queryString_isbn_issn_bookandnonbooksearch(),
                Map.ofEntries(
                        Map.entry("평창군립대화도서관", "MA"),
                        Map.entry("평창군립진부도서관", "MB"),
                        Map.entry("평창군립봉평도서관", "MC"),
                        Map.entry("평창군립꿈여울도서관", "ME"),
                        Map.entry("평창군립HAPPY700용평도서관", "MF"),
                        Map.entry("평창군립방림면계촌도서관", "MG"),
                        Map.entry("평창군립대관령도서관", "MH")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter seoguUrlFormatter() {
        return new SimpleUrlFormatter(
                "seogu.go.kr",
                "https://lib.seogu.go.kr/ilus/index.php?thisLib=%s&act=dataSearchForm" + "&",
                Map.ofEntries(
                        Map.entry("대전 서구 어린이도서관", "H0000017"),
                        Map.entry("둔산도서관", "H0000012"),
                        Map.entry("갈마도서관", "H0000011"),
                        Map.entry("가수원도서관", "H0000014"),
                        Map.entry("월평도서관", "H0000027")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter seosanUrlFormatter() {
        return new IsbnSearchUrlFormatter() {
            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain(
                        "seosan.go.kr",
                        "seosna.go.kr", // 동문 오타
                        "seosnan.go.kr" // 운산 오타
                );
            }

            @Override
            public String getTemplate() {
                return "https://searcheb.seosan.go.kr/dls_le/index.php" + queryString_wdDataSearch();
            }

            @Override
            public Map<String, String> getLibraryNameAndCode() {
                return Map.ofEntries(
                        Map.entry("대산도서관", "144032_AB"),
                        Map.entry("서산시립도서관", "144025_AA"),
                        Map.entry("부석작은도서관", "144123_BC"),
                        Map.entry("인지작은도서관", "144070_BA"),
                        Map.entry("고북작은도서관", "144111_BB"),
                        Map.entry("동문작은도서관", "744153_BD"),
                        Map.entry("운산작은도서관", "744183_DF")
                );
            }
        };
    }

    @Bean
    public IsbnSearchUrlFormatter spUrlFormatter() {
        return new SimpleUrlFormatter(
                ".splib.or.kr",
                "https://www.splib.or.kr/spdlib/menu/10689/program/30002/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("송파글마루도서관", "ME"),
                        Map.entry("송파어린이도서관", "MA"),
                        Map.entry("송파위례도서관", "MH"),
                        Map.entry("거마도서관", "MB"),
                        Map.entry("돌마리도서관", "MF"),
                        Map.entry("소나무언덕1호작은도서관", "BA"),
                        Map.entry("소나무언덕2호작은도서관", "BB"),
                        Map.entry("소나무언덕3호작은도서관", "BC"),
                        Map.entry("소나무언덕4호작은도서관", "BD"),
                        Map.entry("소나무언덕잠실본동도서관", "MC"),
                        Map.entry("송파어린이영어작은도서관", "MD"),
                        Map.entry("가락몰도서관", "MG"),
                        Map.entry("송이골작은도서관", "BE")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter suwonlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "suwonlib.go.kr",
                "https://www.suwonlib.go.kr:8443/search/keyword/"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter tongyeonglibUrlFormatter() {
        return new SimpleUrlFormatter(
                "tongyeonglib.or.kr",
                "https://www.tongyeonglib.or.kr/dls/index.php?mod=wdDataSearch&act=searchResultList&reSearch=1&manageCode=%s&stCode=",
                Map.ofEntries(
                        Map.entry("꿈이랑도서관", "MA"),
                        Map.entry("통영시립욕지도서관", "MB"),
                        Map.entry("통영시립도서관", "MC"),
                        Map.entry("통영시립충무도서관", "MD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter uilibUrlFormatter() {
        return new SimpleUrlFormatter(
                "uilib.go.kr",
                "https://www.uilib.go.kr/main/intro/search/index.do?menu_idx=9&booktype=ALL&libraryCodes=%s&title=",
                Map.ofEntries(
                        Map.entry("의정부가재울도서관", "MD"),
                        Map.entry("의정부정보도서관", "MA"),
                        Map.entry("의정부과학도서관", "MC"),
                        Map.entry("의정부미술도서관", "ME"),
                        Map.entry("의정부음악도서관", "SS"),
                        Map.entry("의정부영어도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ulsannamguUrlFormatter() {
        return new SimpleUrlFormatter(
                "ulsannamgu.go.kr",
                "https://www.ulsannamgu.go.kr/us/search/selectBookSearch.do?searchCmd=normal&searchCnd=-1&searchManageCode=%s&search_txt=",
                Map.ofEntries(
                        Map.entry("울산 남구 도산도서관", "MB"),
                        Map.entry("울산 남구 신복도서관", "MC"),
                        Map.entry("울산 남구 월봉도서관", "MA"),
                        Map.entry("울산 남구 옥현어린이도서관", "MD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter uwlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "uwlib.or.kr",
                "https://www.uwlib.or.kr/jungang/menu/10019/program/30002/searchResultList.do" + queryString_searchWordIsbn(),
                Map.ofEntries(
                        Map.entry("의왕시중앙도서관", "MA"),
                        Map.entry("의왕시내손도서관", "MB"),
                        Map.entry("의왕시글로벌도서관", "MC"),
                        Map.entry("의왕시포일어울림도서관", "MJ"),
                        Map.entry("의왕시백운호수도서관", "MK"),
                        Map.entry("부곡글고운도서관", "ME"),
                        Map.entry("오전빛고운도서관", "MD"),
                        Map.entry("내손책고운도서관", "MF"),
                        Map.entry("청계참고운도서관", "MG"),
                        Map.entry("청계숲고운도서관", "MH"),
                        Map.entry("왕송호수작은도서관", "ML"),
                        Map.entry("숲속옹달샘작은도서관", "NH")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yjlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "yjlib.go.kr",
                "https://www.yjlib.go.kr/web/menu/10037/program/30002/searchResultList.do" + queryString_searchWordIsbn(),
                Map.ofEntries(
                        Map.entry("북내작은도서관", "MD"),
                        Map.entry("여주시립대신도서관", "MF"),
                        Map.entry("여주시립세종도서관", "MB"),
                        Map.entry("여주시립여주도서관", "MA"),
                        Map.entry("여주시립점동도서관", "ME"),
                        Map.entry("산북작은도서관", "MC"),
                        Map.entry("여주기적의도서관", "MH"),
                        Map.entry("여주시립금사도서관", "MG")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yplibUrlFormatter() {
        return new SimpleUrlFormatter(
                "yplib.go.kr",
                "https://www.yplib.go.kr/searchResult?pageIndex=1&keyword="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yeosuUrlFormatter() {
        return new SimpleUrlFormatter(
                "yslib.yeosu.go.kr",
                "https://yslib.yeosu.go.kr/dls_kapi/index.php?mod=wdDataSearch&act=searchResultList&searchItem=allitem&facetManageCode=%s&searchWord=",
                Map.ofEntries(
                        Map.entry("여수시립돌산도서관", "MD"),
                        Map.entry("여수시립소라도서관", "ME"),
                        Map.entry("여수시립쌍봉도서관", "MA"),
                        Map.entry("여수시립율촌도서관", "MF"),
                        Map.entry("여수시립현암도서관", "MB"),
                        Map.entry("여수시립환경도서관", "MC"),
                        Map.entry("여수시립이순신도서관", "MG")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gwangjuUrlFormatter() {
        return new SimpleUrlFormatter(
                "citylib.gwangju.go.kr",
                "https://citylib.gwangju.go.kr/main/bookSearch/advanced?advanced=Y&libCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("광주광역시립무등도서관", "124003"),
                        Map.entry("광주광역시립사직도서관", "124004"),
                        Map.entry("광주광역시립산수도서관", "124008")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gimjeUrlFormatter() {
        return new SimpleUrlFormatter(
                "gjl.gimje.go.kr",
                "https://gjl.gimje.go.kr/index.gimje?menuCd=DOM_000000101001000000&bbo_type=detail&book_type=BOOK&display=30&manage_code=%s&search_isbn_issn=",
                Map.ofEntries(
                        Map.entry("길보작은도서관", "KB"),
                        Map.entry("검산작은도서관", "KS"),
                        Map.entry("김제금구도서관", "GG"),
                        Map.entry("교동골작은도서관", "KD"),
                        Map.entry("김제만경도서관", "MK"),
                        Map.entry("김제시립도서관", "MA"),
                        Map.entry("죽산작은도서관", "JS"),
                        Map.entry("희망남포작은도서관", "HM")
                ),
                List.of("청하사랑작은도서관", "새마을작은도서관")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gmUrlFormatter() {
        return new SimpleUrlFormatter(
                "gmlib.gm.go.kr",
                "https://gmlib.gm.go.kr/dls_le/index.php" + queryString_wdDataSearch(),
                Map.ofEntries(
                        Map.entry("광명시연서도서관", "MJ"),
                        Map.entry("광명시하안도서관", "MB"),
                        Map.entry("광명시충현도서관", "MD"),
                        Map.entry("광명시철산도서관", "ME"),
                        Map.entry("광명시소하도서관", "MF"),
                        Map.entry("광명시광명도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter andongUrlFormatter() {
        // 어거지로 검색되게 쿼리스트링 조작함. 원래 지원안함
        return new SimpleUrlFormatter(
                "andong.go.kr",
                "https://lib.andong.go.kr/andonglibrary/intro/search/index.do?menu_idx=349&search_type=ISBN&rowCount=30&manage_code=%s&search_text=",
                Map.ofEntries(
                        Map.entry("안동시립어린이도서관", "GN"),
                        Map.entry("안동시립웅부도서관", "MA"),
                        Map.entry("안동시립중앙도서관", "OD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter anyangUrlFormatter() {
        return new SimpleUrlFormatter(
                ".anyang.go.kr",
                "https://lib.anyang.go.kr/bakdal/menu/10293/program/30002/searchResultList.do?searchType=DETAIL&searchAdvContentsType=ALL&searchManageCodeArr=%s&searchAdvIsbn=",
                Map.ofEntries(
                        Map.entry("안양시립석수도서관", "MA"),
                        Map.entry("안양시립만안도서관", "MI"),
                        Map.entry("안양시립삼덕도서관", "MH"),
                        Map.entry("안양시립박달도서관", "ME"),
                        Map.entry("안양시립평촌도서관", "MB"),
                        Map.entry("안양시립관양도서관", "MG"),
                        Map.entry("안양시립비산도서관", "MC"),
                        Map.entry("안양시립호계도서관", "MD"),
                        Map.entry("안양시립어린이도서관", "MJ"),
                        Map.entry("안양시립벌말도서관", "MF"),
                        Map.entry("안양시립큰샘어린이도서관", "MO")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gwangjuBukguUrlFormatter() {
        return new SimpleUrlFormatter(
                "bukgu.gwangju.kr",
                "https://lib.bukgu.gwangju.kr/main/bookSearchDetail.do?PID=0301&libCode=%s&queryTitle=+&",
                Map.ofEntries(
                        Map.entry("광주 북구 신용도서관", "129227"),
                        Map.entry("광주 북구 중흥도서관", "129226"),
                        Map.entry("광주 북구 양산도서관", "129225"),
                        Map.entry("광주 북구 운암도서관", "129131"),
                        Map.entry("광주 북구 일곡도서관", "124010")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter changwonUrlFormatter() {
        return new SimpleUrlFormatter(
                "changwon.go.kr",
                "https://searchlib.changwon.go.kr/index.php" + queryString_wdDataSearch(),
                Map.ofEntries(
                        Map.entry("최윤덕도서관", "MO"),
                        Map.entry("고향의봄도서관", "MC"),
                        Map.entry("명곡도서관", "MM")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter daedeokUrlFormatter() {
        return new SimpleUrlFormatter(
                "daedeok.go.kr",
                "https://lib.daedeok.go.kr:8443/index.php?loca=%s&mod=wdDataSearch&act=searchResultList" + "&",
                Map.ofEntries(
                        Map.entry("송촌도서관", "H0000023"),
                        Map.entry("안산도서관", "H0000022"),
                        Map.entry("석봉도서관", "H0000029")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ddcUrlFormatter() {
        return new SimpleUrlFormatter(
                "ddc.go.kr",
                "https://lib.ddc.go.kr/kolaseek/plus/search/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("동두천오르빛도서관", "MC"),
                        Map.entry("동두천시립도서관", "MA"),
                        Map.entry("동두천꿈나무정보도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter dongjakUrlFormatter() {
        return new SimpleUrlFormatter(
                "dongjak.go.kr",
                "https://lib.dongjak.go.kr/dj/intro/search/indexDetail.do?menu_idx=112&booktype=BOOK&rowCount=30&libraryCodes=%s&isbn=",
                Map.ofEntries(
                        Map.entry("까망돌도서관", "lib_ML"),
                        Map.entry("김영삼도서관", "lib_MK"),
                        Map.entry("국사봉숲속작은도서관", "lib_MJ"),
                        Map.entry("동작샘터도서관", "lib_ME"),
                        Map.entry("동작영어마루도서관", "lib_MC"),
                        Map.entry("대방어린이도서관", "lib_MD"),
                        Map.entry("사당솔밭도서관", "lib_MA"),
                        Map.entry("약수도서관", "lib_MF"),
                        Map.entry("다울작은도서관", "lib_MH"),
                        Map.entry("신대방누리도서관", "lib_MN"),
                        Map.entry("신대방햇살", "lib_MP")
                )

        );
    }

    @Bean
    public IsbnSearchUrlFormatter eumseongUrlFormatter() {
        return new SimpleUrlFormatter(
                "eumseong.go.kr",
                "https://lib.eumseong.go.kr/lib/front/index.php" + queryString_isbn_issn(),
                Map.ofEntries(
                        Map.entry("맹동혁신도서관", "MF"),
                        Map.entry("감곡도서관", "MC"),
                        Map.entry("대소도서관", "MA"),
                        Map.entry("삼성도서관", "ME")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter geojeUrlFormatter() {
        return new SimpleUrlFormatter(
                "geoje.go.kr",
                "https://lib.geoje.go.kr/com/requestPage.do?selMenuNo=103010000&returnUrl=/service/bookSearch.do?research_yn=N&search_type=normal&manage_code=%s&search_txt=",
                Map.ofEntries(
                        Map.entry("거제시립수양도서관", "MD"),
                        Map.entry("거제시립아주도서관", "MF"),
                        Map.entry("거제시립옥포도서관", "MB"),
                        Map.entry("거제시립장승포도서관", "MC"),
                        Map.entry("거제시립장평도서관", "MA"),
                        Map.entry("거제시립하청도서관", "ME"),
                        Map.entry("글밭작은도서관", "SE"),
                        Map.entry("남부면작은도서관", "SD"),
                        Map.entry("옥포작은도서관", "SA"),
                        Map.entry("참새미작은도서관", "SC"),
                        Map.entry("둔덕청마꽃들작은도서관", "SG"),
                        Map.entry("외포바다마을작은도서관", "SH"),
                        Map.entry("푸른숲작은도서관", "SF")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gjcityUrlFormatter() {
        return new SimpleUrlFormatter(
                "gjcity.go.kr",
                "https://lib.gjcity.go.kr:8443/kolaseek/plus/search/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("광주시립중앙도서관", "MA"),
                        Map.entry("광주시립오포도서관", "MB"),
                        Map.entry("광주시립초월도서관", "MH"),
                        Map.entry("광주시립곤지암도서관", "MC"),
                        Map.entry("광주시립능평도서관", "MJ"),
                        Map.entry("양벌도서관", "ML"),
                        Map.entry("광남도서관", "MQ"),
                        Map.entry("퇴촌도서관", "MN"),
                        Map.entry("만선도서관", "MP"),
                        Map.entry("대주작은도서관", "MD"),
                        Map.entry("퇴촌작은도서관", "MF"),
                        Map.entry("도척작은도서관", "MG"),
                        Map.entry("광남작은도서관", "MI"),
                        Map.entry("남한산성작은도서관", "MK"),
                        Map.entry("송정작은도서관", "MS"),
                        Map.entry("스마트도서관", "SL")
                ),
                List.of("오포작은도서관")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter goeUrlFormatter() {
        return new SimpleUrlFormatter(
                "goe.go.kr",
                "https://lib.goe.go.kr/gg/intro/search/index.do?menu_idx=10&booktype=BOOKANDNONBOOK&libraryCodes=%s&isbn=",
                Map.ofEntries(
                        Map.entry("경기도교육청중앙도서관", "MA"),
                        Map.entry("경기도교육청성남도서관", "MH"),
                        Map.entry("경기도교육청과천도서관", "MG"),
                        Map.entry("경기도교육청화성도서관", "MJ"),
                        Map.entry("경기도교육청의정부도서관", "MK"),
                        Map.entry("경기도교육청평택도서관", "MB"),
                        Map.entry("경기도교육청포천도서관", "ME"),
                        Map.entry("경기도교육청광주도서관", "MC"),
                        Map.entry("경기도교육청김포도서관", "MF"),
                        Map.entry("경기도교육청여주가남도서관", "MD"),
                        Map.entry("경기도교육청평생학습관", "ML")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter guroUrlFormatter() {
        return new SimpleUrlFormatter(
                "guro.go.kr",
                        "https://lib.guro.go.kr/#/search/ex?rq=BRANCH=%s&all=1|k|a|",
                Map.ofEntries(
                        Map.entry("구로기적의도서관","42"),
                        Map.entry("구로꿈나무어린이도서관","1"),
                        Map.entry("궁동어린이도서관","39"),
                        Map.entry("온누리도서관","28"),
                        Map.entry("개봉도서관","35"),
                        Map.entry("하늘도서관","34"),
                        Map.entry("신도림어린이영어작은도서관","37"),
                        Map.entry("꿈마을도서관","31"),
                        Map.entry("글마루한옥어린이도서관","36")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gweUrlFormatter() {
        return new SimpleUrlFormatter(
                "gwe.go.kr",
                "https://lib.gwe.go.kr/gnecc/menu/234/book/search?search=true&size=30&searchCondition=searchTxt&manageCodes=%s&searchInput=",
                Map.ofEntries(
                        Map.entry("강원특별자치도교육청 강릉교육문화관", "MC"),
                        Map.entry("강원특별자치도교육청 고성교육도서관", "MX"),
                        Map.entry("강원특별자치도교육청 동해교육도서관", "MY"),
                        Map.entry("강원특별자치도교육청 명주교육도서관", "MH"),
                        Map.entry("강원특별자치도교육청 문막교육도서관", "MG"),
                        Map.entry("강원특별자치도교육청 삼척교육문화관", "ME"),
                        Map.entry("강원특별자치도교육청 속초교육도서관", "MJ"),
                        Map.entry("강원특별자치도교육청속초교육문화관", "MD"),
                        Map.entry("강원특별자치도교육청 양구교육도서관", "MV"),
                        Map.entry("강원특별자치도교육청 양양교육도서관", "MK"),
                        Map.entry("강원특별자치도교육청 영월교육도서관", "MQ"),
                        Map.entry("강원특별자치도교육청 원주교육문화관", "MB"),
                        Map.entry("강원특별자치도교육청 인제교육도서관", "MW"),
                        Map.entry("강원특별자치도교육청 정선교육도서관", "MS"),
                        Map.entry("강원특별자치도교육청 철원교육도서관", "MT"),
                        Map.entry("강원특별자치도교육청 춘성교육도서관", "MF"),
                        Map.entry("강원특별자치도교육청 춘천교육문화관", "MA"),
                        Map.entry("강원특별자치도교육청 태백교육도서관", "MM"),
                        Map.entry("강원특별자치도교육청 평창교육도서관", "MR"),
                        Map.entry("강원특별자치도교육청 홍천교육도서관", "MN"),
                        Map.entry("강원특별자치도교육청 화천교육도서관", "MU"),
                        Map.entry("강원특별자치도교육청 횡성교육도서관", "MP")
                )

        );
    }

    @Bean
    public IsbnSearchUrlFormatter iceUrlFormatter() {
        return new SimpleUrlFormatter(
                "ice.go.kr",
                "https://lib.ice.go.kr/jungang/intro/search/indexDetail.do?menu_idx=215&viewPage=1&booktype=BOOK&rowCount=30&libraryCodes=%s&isbn=",
                Map.ofEntries(
                        Map.entry("인천광역시교육청계양도서관", "lib_ME"),
                        Map.entry("인천광역시교육청부평도서관", "lib_MC"),
                        Map.entry("인천광역시교육청서구도서관", "lib_MF"),
                        Map.entry("인천광역시교육청신트리도서관", "lib_MA"),
                        Map.entry("인천광역시교육청연수도서관", "lib_MH"),
                        Map.entry("인천광역시교육청주안도서관", "lib_MD"),
                        Map.entry("인천광역시교육청중앙도서관", "lib_MB"),
                        Map.entry("인천광역시교육청평생학습관", "lib_MJ"),
                        Map.entry("인천광역시교육청화도진도서관", "lib_MG")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter iksanUrlFormatter() {
        return new SimpleUrlFormatter(
                "iksan.go.kr",
                "https://lib.iksan.go.kr/bs/site/search/bookSearch.do?cmd_name=bookandnonbooksearch&search_type=detail&manage_code=%s&search_txt=",
                Map.ofEntries(
                        Map.entry("익산시립모현도서관", "MO"),
                        Map.entry("익산시립영등도서관", "BR"),
                        Map.entry("익산시립마동도서관", "MA"),
                        Map.entry("익산시립부송도서관", "BU"),
                        Map.entry("익산시립유천도서관", "MC"),
                        Map.entry("익산시립황등도서관", "HW"),
                        Map.entry("익산시립금마도서관", "MB"),
                        Map.entry("익산시립모인여행숲도서관", "SX"),
                        Map.entry("익산시립수도산그림책숲도서관", "SW")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jbeUrlFormatter() {
        return new SimpleUrlFormatter(
                "jbe.go.kr",
                "https://lib.jbe.go.kr/bec/intro/search/index.do?menu_idx=218&booktype=BOOK&rowCount=30&libraryCodes=%s" + "&",
                Map.ofEntries(
                        Map.entry("전라북도교육청고창도서관", "lib_MV"),
                        Map.entry("전북특별자치도교육청 군산학생교육문화관", "lib_MB"),
                        Map.entry("전북특별자치도교육청 군산학생교육문화관 대야분관", "lib_MC"),
                        Map.entry("김제교육문화회관", "lib_MH"),
                        Map.entry("전북특별자치도교육청 김제학생교육문화관 금산분관", "lib_MJ"),
                        Map.entry("전북특별자치도교육청 남원학생교육문화관", "lib_MF"),
                        Map.entry("전북특별자치도교육청 남원학생교육문화관 운봉분관", "lib_MG"),
                        Map.entry("전라북도교육청무주도서관", "lib_MR"),
                        Map.entry("전북특별자치도교육청 부안학생교육문화관", "lib_MK"),
                        Map.entry("전라북도교육청순창도서관", "lib_MU"),
                        Map.entry("전라북도교육청완주도서관", "lib_MP"),
                        Map.entry("전북특별자치도교육청 익산학생교육문화관", "lib_MD"),
                        Map.entry("전북특별자치도교육청 익산학생교육문화관 함열분관", "lib_ME"),
                        Map.entry("전라북도교육청임실도서관", "lib_MT"),
                        Map.entry("전라북도교육청장수도서관", "lib_MS"),
                        Map.entry("전북특별자치도교육청 전주학생교육문화관", "lib_MA"),
                        Map.entry("전북특별자치도교육청 진안도서관", "lib_MQ"),
                        Map.entry("정읍학생복지회관", "lib_MN")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jincheonUrlFormatter() {
        return new SimpleUrlFormatter(
                "jincheon.go.kr",
                "https://lib.jincheon.go.kr/lib/front/index.php" + queryString_isbn_issn(),
                Map.ofEntries(
                        Map.entry("진천군립광혜원도서관", "MB"),
                        Map.entry("생거진천혁신도시도서관", "MC"),
                        Map.entry("진천군립도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter nonsanUrlFormatter() {
        return new SimpleUrlFormatter(
                "nonsan.go.kr",
                "https://lib.nonsan.go.kr:8443/dls_le/index.php" + queryString_wdDataSearch(),
                Map.ofEntries(
                        Map.entry("논산열린도서관", "MF"),
                        Map.entry("논산연무도서관", "MD"),
                        Map.entry("논산강경도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter pajuUrlFormatter() {
        return new SimpleUrlFormatter(
                "paju.go.kr",
                "https://lib.paju.go.kr/jalib/menu/10057/program/30005/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("파주시립중앙도서관", "MA"),
                        Map.entry("파주시립금촌도서관", "MB"),
                        Map.entry("파주시립문산도서관", "MC"),
                        Map.entry("파주시립법원도서관", "MD"),
                        Map.entry("파주시립적성도서관", "ME"),
                        Map.entry("파주시립교하도서관", "MQ"),
                        Map.entry("파주시립한빛도서관", "MI"),
                        Map.entry("파주시립해솔도서관", "MH"),
                        Map.entry("파주시립탄현도서관", "MN"),
                        Map.entry("파주시립가람도서관", "MM"),
                        Map.entry("파주시립조리도서관", "MF"),
                        Map.entry("파주시립금촌3동솔빛도서관", "MK"),
                        Map.entry("파주시립물푸레도서관", "ML"),
                        Map.entry("파주시립파평도서관", "MP"),
                        Map.entry("파주시립한울도서관", "MR"),
                        Map.entry("파주시립월롱도서관", "MO"),
                        Map.entry("파주시립광탄도서관", "MS"),
                        Map.entry("파주시립술이홀도서관", "MJ"),
                        Map.entry("금촌무지개작은도서관", "SF"),
                        Map.entry("금곡작은도서관", "SD"),
                        Map.entry("탄현작은도서관", "SA"),
                        Map.entry("파주시립부엉이책장", "SB")
                ),
                List.of("파주시립행복어린이도서관")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter pocheonUrlFormatter() {
        return new SimpleUrlFormatter(
                "pocheon.go.kr",
                "https://lib.pocheon.go.kr/ildong/menu/10367/program/30004/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("면암중앙도서관", "MA"),
                        Map.entry("소흘도서관", "MB"),
                        Map.entry("가산도서관", "MF"),
                        Map.entry("일동도서관", "MC"),
                        Map.entry("영중꿈나무도서관", "MD"),
                        Map.entry("영북도서관", "ME"),
                        Map.entry("선단도서관", "MG")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sejongUrlFormatter() {
        return new SimpleUrlFormatter(
                "sejong.go.kr",
                "https://lib.sejong.go.kr/main/site/search/bookSearch.do" + queryString_isbn_issn_bookandnonbooksearch(),
                Map.ofEntries(
                        Map.entry("세종시립도서관", "MS"),
                        Map.entry("도담동도서관", "MB"),
                        Map.entry("아름동도서관", "MC"),
                        Map.entry("종촌동도서관", "MG"),
                        Map.entry("한솔동도서관", "MA"),
                        Map.entry("고운동도서관", "MJ"),
                        Map.entry("보람동도서관", "MH"),
                        Map.entry("대평동도서관", "MN"),
                        Map.entry("새롬동도서관", "MO"),
                        Map.entry("고운남측도서관", "MP"),
                        Map.entry("소담동도서관", "MQ"),
                        Map.entry("다정동도서관", "MR"),
                        Map.entry("전의도래샘작은도서관", "MK"),
                        Map.entry("소정작은도서관", "ML"),
                        Map.entry("장군면작은도서관", "ME"),
                        Map.entry("조치원어린이도서관", "MF"),
                        Map.entry("해밀동도서관", "MT"),
                        Map.entry("반곡동도서관", "MU"),
                        Map.entry("연동면작은도서관", "MV"),
                        Map.entry("조치원읍도서관", "MW"),
                        Map.entry("싱싱도서관", "MX"),
                        Map.entry("나성동도서관", "NA"),
                        Map.entry("전의나무도서관", "MZ"),
                        Map.entry("어진작은도서관", "MY")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter siheungUrlFormatter() {
        return new SimpleUrlFormatter(
                "siheung.go.kr",
                "https://lib.siheung.go.kr/#/search/si?mashup=PYXIS&rq=BRANCH=%s&all=1|k|a|9788936434120",
                Map.ofEntries(
                        Map.entry("시흥시 능곡도서관", "12"),
                        Map.entry("시흥시 목감도서관", "73"),
                        Map.entry("시흥시 배곧도서관", "75"),
                        Map.entry("시흥시 매화도서관", "14"),
                        Map.entry("시흥시 소래빛도서관", "3"),
                        Map.entry("시흥시 신천도서관", "13"),
                        Map.entry("시흥시 월곶도서관", "4"),
                        Map.entry("시흥시 대야도서관", "2"),
                        Map.entry("시흥시 군자도서관", "11"),
                        Map.entry("시흥시 정왕어린이도서관", "10"),
                        Map.entry("시흥시 중앙도서관", "1"),
                        Map.entry("시흥시 장곡도서관", "16"),
                        Map.entry("시흥시 은계도서관", "81")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter uljinUrlFormatter() {
        return new SimpleUrlFormatter(
                "uljin.go.kr",
                "https://lib.uljin.go.kr/content/01search/01_01.php?detail=ok&sh_TYPE=dan_book&sh_MGC=%s&sh_SIB=",
                Map.ofEntries(
                        Map.entry("근남작은도서관", "SD"),
                        Map.entry("매화작은도서관", "SE"),
                        Map.entry("북울진도서관", "MB"),
                        Map.entry("울진남부도서관", "MA"),
                        Map.entry("울진작은도서관", "SC"),
                        Map.entry("온정작은도서관", "SH"),
                        Map.entry("기성작은도서관", "SF"),
                        Map.entry("평해작은도서관", "SG"),
                        Map.entry("흥부작은도서관", "SJ")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yangcheonUrlFormatter() {
        return new SimpleUrlFormatter(
                "yangcheon.or.kr",
                "https://lib.yangcheon.or.kr/main/site/search/bookSearch.do" + queryString_isbn_issn_bookandnonbooksearch(),
                Map.ofEntries(
                        Map.entry("갈산도서관", "MA"),
                        Map.entry("목마교육도서관", "MB"),
                        Map.entry("방아다리문학도서관", "MC"),
                        Map.entry("신월음악도서관", "MD"),
                        Map.entry("영어특성화도서관", "ME"),
                        Map.entry("해맞이역사도서관", "MF"),
                        Map.entry("개울건강도서관", "MG"),
                        Map.entry("미감도서관", "SG"),
                        Map.entry("양천중앙도서관", "MH"),
                        Map.entry("고운달작은도서관", "SA"),
                        Map.entry("고운맘작은도서관", "SB"),
                        Map.entry("신월3북카페(달빛마을책쉼터", "SC"),
                        Map.entry("목2북카페", "SF"),
                        Map.entry("고맙습니다신정3동작은도서관", "SH"),
                        Map.entry("넓은들 작은도서관", "SJ"),
                        Map.entry("그린나래미술도서관", "SK"),
                        Map.entry("모새미작은도서관", "SM"),
                        Map.entry("목1동 도서방", "UA"),
                        Map.entry("새아름 작은도서관", "UB"),
                        Map.entry("신정6동 도서방", "UD"),
                        Map.entry("신정7동 도서방", "UE"),
                        Map.entry("스마트도서관", "FA")
                )
                /*
                해맞이역사도서관
                방아다리문학도서관
                영어특성화도서관
                개울건강도서관
                갈산도서관
                미감도서관
                목마교육도서관
                신월음악도서관
                양천중앙도서관
                 */
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yuseongUrlFormatter() {
        return new SimpleUrlFormatter(
                "yuseong.go.kr",
                "https://lib.yuseong.go.kr/web/menu/10076/program/30006/searchResultList.do?searchType=DETAIL&vSrchList[0].vSrchKey=0&vSrchList[0].vSrchText=&vSrchList[0].vSrchOp=AND&vLmt2=%s" + "&",
                Map.ofEntries(
                        Map.entry("노은도서관", "H0000015"),
                        Map.entry("유성도서관", "H0000016"),
                        Map.entry("진잠도서관", "H0000018"),
                        Map.entry("구즉도서관", "H0000019"),
                        Map.entry("구암도서관", "H0000020"),
                        Map.entry("원신흥도서관", "H0000026"),
                        Map.entry("아가랑도서관", "H0000028"),
                        Map.entry("관평도서관", "H0000030"),
                        Map.entry("전민도서관", "H0000031"),
                        Map.entry("유성도서관 엑스포분관", "H0000013"),
                        Map.entry("용산도서관", "H0000033")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter cheongjuUrlFormatter() {
        return new SimpleUrlFormatter(
                "cheongju.go.kr",
                "https://library.cheongju.go.kr/lib/dls_le/index.php" + queryString_wdDataSearch(),
                Map.ofEntries(
                        Map.entry("청주시립도서관", "MA"),
                        Map.entry("청주기적의도서관", "MB"),
                        Map.entry("청주서원도서관", "MC"),
                        Map.entry("청주강내도서관", "MD"),
                        Map.entry("청주오창호수도서관", "ME"),
                        Map.entry("청주옥산도서관", "MF"),
                        Map.entry("청주오창도서관", "MG"),
                        Map.entry("청주청원도서관", "MH"),
                        Map.entry("청주오송도서관", "MI"),
                        Map.entry("청주상당도서관", "MJ"),
                        Map.entry("청주흥덕도서관", "MK"),
                        Map.entry("청주신율봉어린이도서관", "ML"),
                        Map.entry("청주금빛도서관", "MM"),
                        Map.entry("청주가로수도서관", "MN"),
                        Map.entry("청주글마루작은도서관", "SA"),
                        Map.entry("청주금호예다움작은도서관", "SB"),
                        Map.entry("청주두꺼비생태작은도서관", "SC"),
                        Map.entry("청주맹꽁이생태작은도서관", "SD"),
                        Map.entry("청주봄눈작은도서관", "SE"),
                        Map.entry("청주봉명작은도서관", "SF"),
                        Map.entry("청주해품터직지작은도서관", "SG"),
                        Map.entry("청주내수도서관", "SH"),
                        Map.entry("청주참도깨비작은도서관", "SK"),
                        Map.entry("청주흥덕보건소스마트도서관", "SN"),
                        Map.entry("청주성화개신스마트도서관", "SO"),
                        Map.entry("청주농협물류스마트도서관", "SM"),
                        Map.entry("청주자료보존관", "AA"),
                        Map.entry("청주율봉스마트도서관", "SP"),
                        Map.entry("청주강서2동스마트도서관", "SQ")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter chilgokUrlFormatter() {
        return new SimpleUrlFormatter(
                "chilgok.go.kr",
                "https://library.chilgok.go.kr/cg/intro/search/index.do?search_type2=ea_isbn&menu_idx=349&search_type=ea_isbn&rowCount=30&manage_code=%s&search_text=",
                Map.ofEntries(
                        Map.entry("칠곡군립도서관", "MA"),
                        Map.entry("칠곡군립북삼도서관", "MC"),
                        Map.entry("칠곡군립석적도서관", "MD"),
                        Map.entry("동명작은도서관", "ME"),
                        Map.entry("약목작은도서관", "MF")
                )
        );
    }


    @Bean
    public IsbnSearchUrlFormatter chuncheonUrlFormatter() {
        return new SimpleUrlFormatter(
                "chuncheon.go.kr",
                "https://library.chuncheon.go.kr/search/book-search/librarybook/?searchType=ALL&bookType=BOOK&display=30&detailFlag=detail&manageCode=%s&searchIsbn=",
                Map.ofEntries(
                        Map.entry("춘천시립소양도서관", "SM"),
                        Map.entry("춘천시립도서관", "MA"),
                        Map.entry("춘천시립남산도서관", "NM"),
                        Map.entry("춘천시립동내도서관", "DM"),
                        Map.entry("춘천시립청소년도서관", "TM"),
                        Map.entry("춘천시립신사우도서관", "HM"),
                        Map.entry("담작은도서관", "DD"),
                        Map.entry("춘천시립서면도서관", "YM")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ulsanDongguUrlFormatter() {
        return new SimpleUrlFormatter(
                "donggu.ulsan.kr",
                "https://library.donggu.ulsan.kr/main/site/search/bookSearch.do" + queryString_isbn_issn_bookandnonbooksearch(),
                Map.ofEntries(
                        Map.entry("남목도서관", "ME"),
                        Map.entry("마성만화도서관", "MA"),
                        Map.entry("전하작은도서관", "MB"),
                        Map.entry("화정아이꿈누리도서관", "MC"),
                        Map.entry("꽃바위작은도서관", "MD"),
                        Map.entry("책놀이터북적북적", "MF")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gwangjuSeoguUrlFormatter() {
        return new SimpleUrlFormatter(
                "seogu.gwangju.kr",
                "https://library.seogu.gwangju.kr/index.9is?contentUid=9be5df897834aa07017868116d3407de" + "&"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sokchoUrlFormatter() {
        return new SimpleUrlFormatter(
                "sokcho.go.kr",
                "https://library.sokcho.go.kr/intro/book/search?searchType=normal&page=1&size=30&search=true&bookType=NORMAL&manageCode=%s&searchInput=",
                Map.ofEntries(
                        Map.entry("속초시립도서관", "MA"),
                        Map.entry("풀이음작은도서관", "MC")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter suncheonUrlFormatter() {
        return new SimpleUrlFormatter(
                "suncheon.go.kr",
                "https://library.suncheon.go.kr/lib/book/search/searchIndex.do?menuCd=L001001001&mediaCode=&nPageSize=30&manageCd=%s&search=",
                Map.ofEntries(
                        Map.entry("순천시립삼산도서관", "MA"),
                        Map.entry("순천시립그림책도서관", "MB"),
                        Map.entry("순천시립연향도서관", "BR"),
                        Map.entry("순천기적의도서관", "MH"),
                        Map.entry("순천시립조례호수도서관", "MC"),
                        Map.entry("순천시립신대도서관", "MJ"),
                        Map.entry("순천시립어울림도서관", "MK"),
                        Map.entry("해룡농어촌도서관", "MD"),
                        Map.entry("풍덕글마루작은도서관", "MG")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter mapoUrlFormatter() {
        return new SimpleUrlFormatter(
                "mapo.go.kr",
                "https://mplib.mapo.go.kr/naru/MENU2133/PGM3008/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("마포중앙도서관", "HQ"),
                        Map.entry("마포소금나루도서관", "MN"),
                        Map.entry("마포서강도서관", "MA"),
                        Map.entry("마포푸르메어린이도서관", "HK"),
                        Map.entry("마포나루메타버스도서관", "DO"),
                        Map.entry("마포어린이영어도서관", "MK"),
                        Map.entry("꿈나래어린이영어도서관", "ML"),
                        Map.entry("성산글마루작은도서관", "MI"),
                        Map.entry("꿈을이루는작은도서관", "ME"),
                        Map.entry("늘푸른소나무작은도서관", "MF"),
                        Map.entry("복사골작은도서관", "MC"),
                        Map.entry("성메작은도서관", "MG"),
                        Map.entry("아름드리작은도서관", "MH"),
                        Map.entry("용강동작은도서관", "MJ"),
                        Map.entry("마포초록숲작은도서관", "MM"),
                        Map.entry("해오름작은도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter nowonlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "nowonlib.kr",
                "https://nowonlib.kr/KeywordSearchResult/"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter snlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "snlib.go.kr",
                "https://www.snlib.go.kr/ct/menu/10137/program/30010/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("성남시 중앙도서관", "MA"),
                        Map.entry("성남시 고등도서관", "MD"),
                        Map.entry("성남시 구미도서관", "MG"),
                        Map.entry("성남시 논골도서관", "BF"),
                        Map.entry("성남시 무지개도서관", "MM"),
                        Map.entry("성남시 복정도서관", "MW"),
                        Map.entry("성남시 분당도서관", "MB"),
                        Map.entry("성남시 서현도서관", "MV"),
                        Map.entry("성남시 수내도서관", "MO"),
                        Map.entry("성남시 수정도서관", "MS"),
                        Map.entry("성남시 운중도서관", "MU"),
                        Map.entry("성남시 위례도서관", "MR"),
                        Map.entry("성남시 중원도서관", "MJ"),
                        Map.entry("성남시 중원어린이도서관", "CK"),
                        Map.entry("성남시 책테마파크도서관", "MT"),
                        Map.entry("성남시 판교도서관", "MP"),
                        Map.entry("성남시 판교어린이도서관", "PK"),
                        Map.entry("성남시 해오름도서관", "MH")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ulsanBukguUrlFormatter() {
        return new SimpleUrlFormatter(
                "bukgu.ulsan.kr",
                "https://usbl.bukgu.ulsan.kr/main/site/search/bookSearch.do" + queryString_isbn_issn_bookandnonbooksearch(),
                Map.ofEntries(
                        Map.entry("울산 북구 중앙도서관", "MA"),
                        Map.entry("울산 북구 송정나래도서관", "SJ"),
                        Map.entry("울산 북구 매곡도서관", "MG"),
                        Map.entry("울산 북구 농소1동도서관", "NS"),
                        Map.entry("울산 북구 명촌어린이도서관", "BA"),
                        Map.entry("울산 북구 농소3동도서관", "NT"),
                        Map.entry("울산 북구 기적의도서관", "KM"),
                        Map.entry("울산 북구 강동바다도서관", "GD"),
                        Map.entry("울산 북구 염포양정도서관", "YM"),
                        Map.entry("푸른작은도서관", "CC"),
                        Map.entry("책가방작은도서관", "CB"),
                        Map.entry("책사랑작은도서관", "CA"),
                        Map.entry("책누리작은도서관", "CH"),
                        Map.entry("책놀이터작은도서관", "CJ"),
                        Map.entry("다울림작은도서관", "CI"),
                        Map.entry("책마루작은도서관", "CK"),
                        Map.entry("가온누리작은도서관", "CL"),
                        Map.entry("양정작은도서관(달팽이)", "CM"),
                        Map.entry("햇살작은도서관", "CN"),
                        Map.entry("꿈꾸는작은도서관", "CO"),
                        Map.entry("아름드리작은도서관", "CP"),
                        Map.entry("극동푸른작은도서관", "CR"),
                        Map.entry("책읽는풍경작은도서관", "CS")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter chungjuUrlFormatter() {
        return new SimpleUrlFormatter(
                "chungju.go.kr",
                "https://lib.chungju.go.kr/web/menu/10042/program/30002/searchResultList.do" + queryString_searchWordIsbn(),
                Map.ofEntries(
                        Map.entry("충주시립도서관", "MA"),
                        Map.entry("충주시립어린이청소년도서관", "MC"),
                        Map.entry("서충주도서관", "MD"),
                        Map.entry("충주시립호암도서관", "BR"),
                        Map.entry("충주시립엄정꿈터도서관", "SH"),
                        Map.entry("충주시립호암어린이도서관", "SK"),
                        Map.entry("충주시립목행작은도서관", "SA"),
                        Map.entry("충주시립무학작은도서관", "SI"),
                        Map.entry("충주시립봉방작은도서관", "MB"),
                        Map.entry("충주시립수안보작은도서관", "SD"),
                        Map.entry("충주시립시청작은도서관", "SE"),
                        Map.entry("충주시립안림푸른작은도서관", "SJ"),
                        Map.entry("충주시립연수힐스작은도서관", "SB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter danyangUrlFormatter() {
        return new SimpleUrlFormatter(
                "danyang.go.kr",
                "https://www.danyang.go.kr/lib/dls_lt/index.php?mod=wdDataSearch&act=searchResultList&manageCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("단양군립올누림도서관", "MA"),
                        Map.entry("단양군립매포도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gaplibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gaplib.go.kr",
                "https://www.gaplib.go.kr/intro/menu/10036/program/30006/searchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("가평군 한석봉도서관", "MA"),
                        Map.entry("가평군 설악도서관", "MC"),
                        Map.entry("가평군 청평도서관", "MD"),
                        Map.entry("가평군 조종도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gblibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gblib.or.kr",
                        "https://www.gblib.or.kr/gangbuk/search/total.do#uri=list&a_v=f&a_cp=1&a_qf=I&a_vp=10&a_lib=%s&a_q=",
                Map.ofEntries(
                        Map.entry("강북문화정보도서관", "MA"),
                        Map.entry("삼각산어린이도서관", "MH"),
                        Map.entry("미아문화정보도서관", "MG"),
                        Map.entry("솔샘문화정보도서관", "MC"),
                        Map.entry("송중문화정보도서관", "NC"),
                        Map.entry("수유문화정보도서관", "ME"),
                        Map.entry("강북청소년문화정보도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ghlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "ghlib.go.kr",
                "https://www.ghlib.go.kr/BookSearch/detail?libCode=%s&",
                Map.ofEntries(
                        Map.entry("고흥군립남부도서관", "MB"),
                        Map.entry("고흥군립북부도서관", "MC"),
                        Map.entry("고흥군립중앙도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gokseongUrlFormatter() {
        return new SimpleUrlFormatter(
                "gokseong.go.kr",
                "https://www.gokseong.go.kr/library/BookSearch/detail?libCode=%s&",
                Map.ofEntries(
                        Map.entry("옥과공공도서관","MA"),
                        Map.entry("곡성어린이도서관","ZF")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gongjulibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gongjulib.go.kr",
                "https://www.gongjulib.go.kr/dkbw/dls_le/index.php" + queryString_wdDataSearch(),
                Map.ofEntries(
                        Map.entry("공주시 웅진도서관", "WJ"),
                        Map.entry("공주기적의도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter goyanglibUrlFormatter() {
        return new SimpleUrlFormatter(
                "goyanglib.or.kr",
                "https://www.goyanglib.or.kr/center/menu/10004/program/30002/searchResultList.do?searchType=DETAIL&searchManageCodeArr=%s&searchAdvIsbn=",
                Map.ofEntries(
                        Map.entry("관산작은도서관","BE"),
                        Map.entry("화전작은도서관","BA"),
                        Map.entry("사리현작은도서관","BB"),
                        Map.entry("모당공원작은도서관","BN"),
                        Map.entry("마상공원작은도서관","BM"),
                        Map.entry("대덕작은도서관","BD"),
                        Map.entry("내유작은도서관","BO"),
                        Map.entry("고양시립마두도서관","MA"),
                        Map.entry("고양시립행신도서관","MB"),
                        Map.entry("고양시립화정도서관","ME"),
                        Map.entry("고양시립아람누리도서관","MF"),
                        Map.entry("고양시립주엽어린이도서관","MG"),
                        Map.entry("고양시립행신어린이도서관","MH"),
                        Map.entry("고양시립화정어린이도서관","MI"),
                        Map.entry("고양시립대화도서관","MJ"),
                        Map.entry("고양시립한뫼도서관","MK"),
                        Map.entry("고양시립풍동도서관","ML"),
                        Map.entry("고양시립식사도서관","MM"),
                        Map.entry("고양시립덕이도서관","MN"),
                        Map.entry("고양시립신원도서관","MO"),
                        Map.entry("고양시립삼송도서관","MP"),
                        Map.entry("고양시립별꿈도서관","MQ"),
                        Map.entry("고양시립가좌도서관","MT"),
                        Map.entry("고양시립일산도서관","MU"),
                        Map.entry("고양시립높빛도서관","MV")
                ),
                List.of("고양시립원당도서관", "고양시립백석도서관") // 휴관중
        );
    }

    @Bean
    public IsbnSearchUrlFormatter hanamlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "hanamlib.go.kr",
                "https://www.hanamlib.go.kr/kolaseek/search/plusSearchResultList.do?searchType=DETAIL&searchKey5=ISBN&searchRecordCount=30&searchKdc=&searchLibrary=%s&searchKeyword5=",
                Map.ofEntries(
                        Map.entry("하남시 나룰도서관", "MB"),
                        Map.entry("하남시 신장도서관", "MA"),
                        Map.entry("하남시 덕풍도서관", "MC"),
                        Map.entry("하남시 세미도서관", "MD"),
                        Map.entry("하남시 디지털도서관", "ME"),
                        Map.entry("하남시 미사도서관", "MS"),
                        Map.entry("하남시 위례도서관", "MF"),
                        Map.entry("하남시 일가도서관", "IG"),
                        Map.entry("하남시 어울림작은도서관", "MG"),
                        Map.entry("하남시 덕풍스포츠작은도서관", "MH")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter junggulibUrlFormatter() {
        return new SimpleUrlFormatter(
                "junggulib.or.kr",
                "https://www.junggulib.or.kr/SJGL/menu/10004/program/30002/searchResultList.do?searchType=ADVANCED&searchAdvContentsType=ALL&searchManageCodeArr=%s&searchAdvIsbn=",
                Map.ofEntries(
                        Map.entry("남산타운 어린이도서관", "MD"),
                        Map.entry("신당누리도서관", "MC"),
                        Map.entry("손기정 어린이도서관", "ME"),
                        Map.entry("손기정 문화도서관", "MB"),
                        Map.entry("장충동 작은도서관", "CA"),
                        Map.entry("다산성곽도서관", "MA"),
                        Map.entry("가온도서관", "MF"),
                        Map.entry("어울림도서관", "MH")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter libyjUrlFormatter() {
        return new SimpleUrlFormatter(
                "libyj.go.kr",
                "https://www.libyj.go.kr/djlib/menu/10190/program/30012/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("양주시립옥정호수도서관", "141605"),
                        Map.entry("양주시립덕정도서관", "141037"),
                        Map.entry("양주시립꿈나무도서관", "141098"),
                        Map.entry("양주시립남면도서관", "141154"),
                        Map.entry("양주시립고읍도서관", "141323"),
                        Map.entry("양주시립덕계도서관", "141545"),
                        Map.entry("양주시립광적도서관", "141581"),
                        Map.entry("장흥작은도서관", "141300"),
                        Map.entry("양주희망도서관", "141558"),
                        Map.entry("고암작은도서관", "741758")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter mokpolibUrlFormatter() {
        return new SimpleUrlFormatter(
                "mokpolib.or.kr",
                "https://www.mokpolib.or.kr/dls_lt/index.php?mod=wdDataSearch&act=searchResultList&deSearch=1&manageCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("목포시립도서관", "MA"),
                        Map.entry("목포어린이도서관", "MJ"),
                        Map.entry("목포영어도서관", "MQ"),
                        Map.entry("목포어울림도서관", "MX")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter namdonglibUrlFormatter() {
        return new SimpleUrlFormatter(
                "namdonglib.go.kr",
                "https://alpasq.namdonglib.go.kr/search/keyword/"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter namwonUrlFormatter() {
        return new SimpleUrlFormatter(
                "namwon.go.kr",
                "https://www.namwon.go.kr/lib/web/menu/10018/program/30004/searchResultList.do" + queryString_searchWordIsbn(),
                Map.ofEntries(
                        Map.entry("남원시립도서관", "MA"),
                        Map.entry("남원시어린이청소년도서관", "MN"),
                        Map.entry("남원시어울림도서관", "MU")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ptlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "ptlib.go.kr",
                "https://www.ptlib.go.kr/intro/menu/10046/program/30016/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("매봉작은도서관", "BA"),
                        Map.entry("송탄작은도서관", "BB"),
                        Map.entry("서정작은도서관", "BC"),
                        Map.entry("포승작은도서관", "BD"),

                        Map.entry("평택시립배다리도서관", "MJ"),
                        Map.entry("평택시립비전도서관", "MA"),
                        Map.entry("평택시립팽성도서관", "MB"),
                        Map.entry("평택시립안중도서관", "MC"),
                        Map.entry("평택시립지산초록도서관", "MD"),
                        Map.entry("평택시립오성도서관", "ME"),
                        Map.entry("평택시립장당도서관", "MF"),
                        Map.entry("평택시립진위도서관", "MG"),
                        Map.entry("평택시립세교도서관", "MH"),
                        Map.entry("평택시립한국근현대음악도서관", "MK"),
                        Map.entry("평택시립청북도서관", "BE")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sblibUrlFormatter() {
        return new SimpleUrlFormatter(
                "sblib.seoul.kr",
                "https://www.sblib.seoul.kr/library/menu/10013/program/30004/searchResultList.do?categoryManageCode=%s&detailISBN=",
                Map.ofEntries(
                    Map.entry("성북정보도서관", "BR"),
                    Map.entry("아리랑도서관", "MA"),
                    Map.entry("해오름도서관", "BT"),
                    Map.entry("종암동새날도서관", "TR"),
                    Map.entry("서경로꿈마루도서관", "ME"),
                    Map.entry("석관동미리내도서관", "MF"),
                    Map.entry("달빛마루도서관", "MI"),
                    Map.entry("정릉도서관", "MG"),
                    Map.entry("청수도서관", "MJ"),
                    Map.entry("월곡꿈그림도서관", "MK"),
                    Map.entry("아리랑어린이도서관", "ML"),
                    Map.entry("장위행복누림도서관", "MM"),
                    Map.entry("성북길빛도서관", "MN"),
                    Map.entry("글빛도서관", "MO"),
                    Map.entry("오동숲속도서관", "MZ"),
                    Map.entry("보문숲길도서관", "BA"),
                    Map.entry("어린이청소년도서관", "MP")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sdlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "sdlib.or.kr",
                "https://www.sdlib.or.kr/SD/site/search/search00.do" + queryString_isbn_issn_bookandnonbooksearch(),
                Map.ofEntries(
                        Map.entry("성동구립도서관", "MA"),
                        Map.entry("성동구립 무지개도서관", "MB"),
                        Map.entry("성동구립 금호도서관", "MC"),
                        Map.entry("성동구립 용답도서관", "MD"),
                        Map.entry("성동구립 성수도서관", "ME"),
                        Map.entry("성동구립 청계도서관", "MF"),
                        Map.entry("성동구립 매봉산 숲속도서관", "MG"),
                        Map.entry("왕십리제2동작은도서관", "SG"),
                        Map.entry("마장동작은도서관", "SH"),
                        Map.entry("사근동어린이놀이터도서관", "SJ"),
                        Map.entry("행당제2동어린이작은도서관", "SK"),
                        Map.entry("응봉동어린이작은도서관", "SL"),
                        Map.entry("금호1가동숲속작은도서관", "SM"),
                        Map.entry("금호2", "SN"),
                        Map.entry("금호4가동작은도서관", "SP"),
                        Map.entry("옥수동", "SQ"),
                        Map.entry("성수1가제1동작은도서관", "SR"),
                        Map.entry("성수1가제2동작은도서관", "SS"),
                        Map.entry("성수2가제1동작은도서관", "SU"),
                        Map.entry("성수2가제3동작은도서관", "SV"),
                        Map.entry("송정동늘푸른작은도서관", "SW"),
                        Map.entry("용답동어린이작은도서관", "SX"),
                        Map.entry("왕십리도선동희망문고", "SY")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter taebaekUrlFormatter() {
        return new SimpleUrlFormatter(
                "taebaek.go.kr",
                "https://lib.taebaek.go.kr/kolaseek/plus/search/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("태백시립도서관", "MA"),
                        Map.entry("태백시립산소드림도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter uscUrlFormatter() {
        return new SimpleUrlFormatter(
                "usc.go.kr",
                "https://www.usc.go.kr/library/page.do?mnu_uid=745" + "&"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ydplibUrlFormatter() {
        return new SimpleUrlFormatter(
                "ydplib.or.kr",
                "https://www.ydplib.or.kr/sclib/menu/12287/program/30002/plusSearchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("신길도서관", "CE"),
                        Map.entry("대림도서관", "CA"),
                        Map.entry("문래도서관", "CB"),
                        Map.entry("선유도서관", "CC"),
                        Map.entry("여의샛강도서관", "MA"),
                        Map.entry("영등포생각공장도서관", "LX"),
                        Map.entry("원지공원도서관", "LY"),
                        Map.entry("밤동산작은도서관", "LW"),
                        Map.entry("조롱박작은도서관", "CF"),
                        Map.entry("당산1동 작은도서관", "LF"),
                        Map.entry("당산2동 작은도서관", "LG"),
                        Map.entry("대림1동 작은도서관", "LR"),
                        Map.entry("대림2동 작은도서관", "LS"),
                        Map.entry("목화마을 작은도서관", "LU"),
                        Map.entry("신길1동 작은도서관", "LL"),
                        Map.entry("청소년문화의집 작은도서관", "LC"),
                        Map.entry("신길4동 작은도서관", "LN"),
                        Map.entry("신길5동 작은도서관", "LO"),
                        Map.entry("신길6동 작은도서관", "LP"),
                        Map.entry("신길7동 작은도서관", "LQ"),
                        Map.entry("양평1동 작은도서관", "LJ"),
                        Map.entry("양평2동 작은도서관", "LK"),
                        Map.entry("여의동 작은도서관", "LE"),
                        Map.entry("영등포동 작은도서관", "LD"),
                        Map.entry("영등포본동 작은도서관", "LB"),
                        Map.entry("늘샘드리 작은도서관", "LV"),
                        Map.entry("영등포스마트도서관", "CD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yslibraryUrlFormatter() {
        return new SimpleUrlFormatter(
                "yslibrary.or.kr",
                "https://www.yslibrary.or.kr/cheongpa/menu/10035/program/30014/searchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("용산꿈나무도서관", "MA"),
                        Map.entry("청파도서관", "MB"),
                        Map.entry("용마루어린이도서관", "OA"),
                        Map.entry("청파어린이영어도서관", "SA"),
                        Map.entry("용암어린이영어도서관", "YB"),
                        Map.entry("후암동 작은도서관 북앤캠프", "YC"),
                        Map.entry("해다올 작은도서관", "YD"),
                        Map.entry("원효로제2동 작은도서관", "YF"),
                        Map.entry("효창동 작은도서관", "YG"),
                        Map.entry("한강로동 작은도서관", "YI"),
                        Map.entry("이촌2동 작은도서관", "YJ"),
                        Map.entry("회나무 작은도서관", "YK"),
                        Map.entry("서빙고동 작은도서관", "YM"),
                        Map.entry("작은도서관 꿈꾸는책마을", "YN"),
                        Map.entry("별밭 작은도서관", "YS"),
                        Map.entry("청소년 푸르미르 작은도서관", "YO")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ysplibUrlFormatter() {
        return new SimpleUrlFormatter(
                "ysplib.go.kr",
                "https://www.ysplib.go.kr:8443/dkbw/dls_lt/index.php?mod=wdDataSearch&act=searchResultList&deSearch=1&manageCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("예산군립도서관", "MB"),
                        Map.entry("삽교공공도서관", "MA"),
                        Map.entry("덕산작은도서관", "MC"),
                        Map.entry("광시작은도서관", "ME"),
                        Map.entry("고덕작은도서관", "MD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter usulUrlFormatter() {
        return new SimpleUrlFormatter(
                "usul.or.kr",
                "https://search.usul.or.kr/dls_lt/index.php" + queryString_wdDataSearch_NoRegion()
        );
    }

    @Bean
    public IsbnSearchUrlFormatter usnlUrlFormatter() {
        return new SimpleUrlFormatter(
                "usnl.or.kr",
                "https://search.usnl.or.kr/dls_lt/index.php" + queryString_wdDataSearch_NoRegion()
        );
    }

    @Bean
    public IsbnSearchUrlFormatter usdlUrlFormatter() {
        return new SimpleUrlFormatter(
                "usdl.or.kr",
                "http://kcms.usdl.or.kr:9090/kcms/KBookSearch/BookNomalSearch/MA?book_type=BOOK&manage_code=MA&search_txt=&display=10&detail_search_type=Detail&real_search_text=&search_isbn_issn="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter taeanUrlFormatter() {
        return new SimpleUrlFormatter(
                "taean.go.kr",
                "http://211.184.209.66/dls_lt/index.php?mod=wdDataSearch&act=searchResultList&deSearch=1&manageCode=%s&isbn=",
                Map.ofEntries(
                        Map.entry("태안군안면공공도서관", "MA"),
                        Map.entry("태안군립중앙도서관", "MD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter namhaeUrlFormatter() {
        return new SimpleUrlFormatter(
                "namhae.go.kr",
                "https://lib.namhae.go.kr:8443/kolas3_01/BookSearch/search_result.do" + queryString_jongbook_buhovalue()
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jecheonUrlFormatter() {
        return new SimpleMultiUrlFormatter(
                List.of(
                        "jecheon.go.kr", // 제천시립
                        "kidslib.org" // 제천기적의도서관
                ),
                "https://libsearch.jecheon.go.kr/bookSearch.do?detail=N&facetManageCode=%s&searchWord=",
                Map.ofEntries(
                        Map.entry("제천시립도서관", "MA"),
                        Map.entry("여성도서관", "MG"),
                        Map.entry("봉양도서관", "MF"),
                        Map.entry("제천기적의도서관", "MB"),
                        Map.entry("산책도서관", "ME"),
                        Map.entry("신백한울타리도서관", "MC"),
                        Map.entry("하소내보물1호도서관", "MD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter imlaUrlFormatter() {
        return new SimpleMultiUrlFormatter(
                List.of(
                        "imla.kr", // 수봉, 율목
                        ".ylib.or.kr" // 영종
                ),
                "https://www.imla.kr:7443/search/list.jsp?pageSize=30&MANAGE_CODE=%s&ST_CODE=",
                Map.ofEntries(
                        Map.entry("인천광역시 수봉도서관","128017"),
                        Map.entry("인천광역시 율목도서관","128046"),
                        Map.entry("인천광역시 영종도서관","128015")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter hongsanlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "hongsanlib.or.kr",
                "https://www.hongsanlib.or.kr/dls_lt/index.php" + queryString_wdDataSearch_searchResultList(),
                Map.ofEntries(
                        Map.entry("홍산공공도서관", "MA"),
                        Map.entry("행복담은도서관", "MB")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter hmlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "hmlib.or.kr",
                "https://www.hmlib.or.kr/dls_lt/index.php" + queryString_wdDataSearch_searchResultList(),
                Map.ofEntries(
                        Map.entry("해밀도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter hamanUrlFormatter() {
        return new SimpleUrlFormatter(
                "haman.go.kr",
                "http://cwl.haman.go.kr:8800/kolas3_2018/BookSearch/search_result.do?govname=&msa=&formclass=&textlang=&simplelang=&limitpage=30&local=&jongbook=on&buho1=SIB&startpage=1&mode=0&buhovalue1="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gunpolibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gunpolib.go.kr",
                "https://www.gunpolib.go.kr/#/search/ex?rq=BRANCH=6&all=1|l|a|",
                Map.ofEntries(
                        Map.entry("군포시중앙도서관", "6")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gbUrlFormatter() {
        return new SimpleUrlFormatter(
                "gb.go.kr",
                "https://www.gb.go.kr/lib/solars/book/search.tc?mn=2355&pageSeq=1594&searchType=detail&searchAt=Y&searchCondition=all&searchKeyword=&detailTitle=&detailAuthor=&detailPublisher=&detailKeyword=&detailPublisherYear=&materialType=&location=&pagingUnit=30&detailIsbn="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter daejeonUrlFormatter() {
        return new SimpleUrlFormatter(
                "daejeon.go.kr",
                "https://www.daejeon.go.kr/hanbatlibrary/dataSearch.do?menuSeq=6222#" + "?"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter cngUrlFormatter() {
        return new SimpleUrlFormatter(
                "cng.go.kr",
                "https://ysl.cng.go.kr/kolas3_2018/BookSearch/search_result.do" + queryString_jongbook_buhovalue()
        );
    }

    @Bean
    public IsbnSearchUrlFormatter capcUrlFormatter() {
        return new SimpleUrlFormatter(
                "capc.go.kr",
                "https://www.capc.go.kr/library/dls_lt/index.php?mod=wdDataSearch&act=searchResultList&deSearch=%s&isbn=",
                Map.ofEntries(
                        Map.entry("천안아산상생협력센터도서관", "1")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter uLibraryUrlFormatter() {
        return new SimpleUrlFormatter(
                "small.u-library.kr",
                "https://small.u-library.kr/search/tot"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter seocheonUrlFormatter() {
        return new SimpleUrlFormatter(
                "seocheon.go.kr",
                "https://seocheon.go.kr/lib/menu/10020/program/30002/searchResultList.do" + queryString_searchKeyword5(),
                Map.ofEntries(
                        Map.entry("장항공공도서관", "MA"),
                        Map.entry("판교작은도서관", "MB"),
                        Map.entry("문산작은도서관", "MC"),
                        Map.entry("물버들마을도서관", "ME")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter ulsanUrlFormatter() {
        return new SimpleUrlFormatter(
                "ulsan.go.kr",
                "https://library.ulsan.go.kr/us/search/selectBookSearch.do?searchCmd=detail&search_txt=9788936434120&searchIsbn="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter mujuUrlFormatter() {
        return new SimpleUrlFormatter(
                "muju.go.kr",
                "https://library.muju.go.kr/main/site/search/search00.do" + queryString_isbn_issn_bookandnonbooksearch(),
                Map.ofEntries(
                        Map.entry("무주형설지공도서관","MA"),
                        Map.entry("무주만나작은도서관","MB"),
                        Map.entry("무주반딧불작은도서관","MC"),
                        Map.entry("무주안성작은도서관","MD"),
                        Map.entry("무주샘누리작은도서관","ME"),
                        Map.entry("무주오색단풍작은도서관","MF"),
                        Map.entry("무주무풍십승지작은도서관","MG")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter chungnamUrlFormatter() {
        return new SimpleUrlFormatter(
                "chungnam.go.kr",
                        "https://lib.sje.go.kr/prog/bookSearch/sjelib/sub01_01/list.do?reg_no=&searchCaseChk=&non_contact_yn=&search_txt=9788936434120&radio_search=bookSearch&searchKeyword=9788936434120"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sjeUrlFormatter() {
        return new SimpleUrlFormatter(
                "sje.go.kr",
                "https://lib.sje.go.kr/prog/bookSearch/sjelib/sub01_01/list.do?search_txt="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jpUrlFormatter() {
        return new SimpleUrlFormatter(
                "jp.go.kr",
                "https://lib.jp.go.kr/dls_lt/index.php" + queryString_wdDataSearch_searchResultList(),
                Map.ofEntries(
                        Map.entry("증평군립도서관", "MA"),
                        Map.entry("창의파크작은도서관", "BA"),
                        Map.entry("어울림공립작은도서관", "CA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jeonnamUrlFormatter() {
        return new SimpleUrlFormatter(
                "jeonnam.go.kr",
                "https://lib.jeonnam.go.kr/plus/search_list.php?jongbook=1&act=2&limitpage=10&field1=IAL&aon1=AND&field2=IT&field3=IA&field4=IP&field5=IK&buho1=SIB&buho2=KDC&value1=&value2=+&aon2=AND&value3=&aon3=AND&value4=&aon4=AND&value5=&aon5=AND&value6=&aon5=AND&formclass=&sort=&buhovalue1="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jeongseonUrlFormatter() {
        return new SimpleUrlFormatter(
                "jeongseon.go.kr",
                "https://lib.jeongseon.go.kr/intro/total?searchKeyword=pageno=1&display=30&search_type=normal&facet_manage_code=%s&search_txt=",
                Map.ofEntries(
                        Map.entry("정선군립도서관","MB"),
                        Map.entry("사북공공도서관","MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter haenamUrlFormatter() {
        return new SimpleUrlFormatter(
                "haenam.go.kr",
                "https://lib.haenam.go.kr/dls_lt/index.php" + queryString_wdDataSearch_searchResultList(),
                Map.ofEntries(
                        Map.entry("해남군립도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gyeongnamUrlFormatter() {
        return new SimpleUrlFormatter(
                "gyeongnam.go.kr",
                "https://lib.gyeongnam.go.kr/index.lib?menuCd=DOM_000000201001014000&search_select=search_isbn_issn&search_text="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter guryeUrlFormatter() {
        return new SimpleUrlFormatter(
                "gurye.go.kr",
                "https://lib.gurye.go.kr/BookSearch/detail?"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter boeunUrlFormatter() {
        return new SimpleUrlFormatter(
                "boeun.go.kr",
                "https://lib.boeun.go.kr/dls_lt/index.php" + queryString_wdDataSearch_searchResultList(),
                Map.ofEntries(
                        Map.entry("보은군립도서관", "MA")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter kblibUrlFormatter() {
        return new SimpleUrlFormatter(
                "kblib.or.kr",
                "https://kblib.or.kr/kbLib/uce/book/bookSearchList?ea_isbn="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jccfreshUrlFormatter() {
        return new SimpleUrlFormatter(
                "jccfresh.or.kr",
                "https://libsearch.jecheon.go.kr/bookSearch.do?detail=Y&manageCode=%s&searchIsbn=",
                Map.ofEntries(
                        Map.entry("시립도서관", "MA"),
                        Map.entry("여성도서관", "MG"),
                        Map.entry("봉양도서관", "MF"),
                        Map.entry("기적의 도서관", "MB"),
                        Map.entry("산책도서관", "ME"),
                        Map.entry("신백한울타리도서관", "MC"),
                        Map.entry("하소내보물1호도서관", "MD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter hongseongUrlFormatter() {
        return new SimpleUrlFormatter(
                "hongseong.go.kr",
                "https://hongseong.go.kr/prog/bookSearch/gclib/sub02_01/list.do?search_type=normal&manage_codes=%s&search_txt=",
                Map.ofEntries(
                        Map.entry("광천공공도서관", "MA"),
                        Map.entry("글마루작은도서관", "MB"),
                        Map.entry("한울작은도서관", "MC"),
                        Map.entry("홍화문작은도서관", "MD"),
                        Map.entry("늘배움터 작은도서관", "MQ"),
                        Map.entry("LH남장3단지작은도서관", "MP"),
                        Map.entry("경남아너스빌작은도서관", "MG"),
                        Map.entry("내포마을도서관", "ME"),
                        Map.entry("다올책사랑방작은도서관", "MK"),
                        Map.entry("롯데캐슬작은도서관", "ML"),
                        Map.entry("모아작은도서관", "MH"),
                        Map.entry("밝맑도서관", "MM"),
                        Map.entry("신동아작은도서관", "MF"),
                        Map.entry("우리함께작은도서관", "MN"),
                        Map.entry("우아영작은도서관", "MJ")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter brcnUrlFormatter() {
        return new SimpleUrlFormatter(
                "brcn.go.kr",
                "https://brcn.go.kr/lib/front/index.php" + queryString_isbn_issn(),
                Map.ofEntries(
                        Map.entry("보령시중앙도서관", "MA"), // 시립 = 보령시중앙도서관이랑 주소일치
                        Map.entry("죽정도서관", "MC"),
                        Map.entry("주산도서관", "ME"),
                        Map.entry("북드라이브스루", "MP"),
                        Map.entry("오천작은도서관", "MB"),
                        Map.entry("대천항작은도서관", "MD"),
                        Map.entry("서고", "MG"),
                        Map.entry("문화의전당작은도서관", "MH"),
                        Map.entry("청라애작은도서관", "MM"),
                        Map.entry("성주고을작은도서관", "MN"),
                        Map.entry("주교작은도서관", "MO")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter yclibUrlFormatter() {
        return new SimpleUrlFormatter(
                "yclib.go.kr",
                "https://www.yclib.go.kr/homepage/dls_lt/index.php" + queryString_wdDataSearch_searchResultList(),
                Map.ofEntries(
                        Map.entry("영천시립도서관", "MA"),
                        Map.entry("완산뜨락작은도서관", "BA"),
                        Map.entry("북안작은도서관", "BC")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter shinanUrlFormatter() {
        return new SimpleUrlFormatter(
                "shinan.go.kr",
                "https://shinanlib.kr/dls_lt/index.php?mod=wdDataSearch&act=searchResultList&deSearch=1s&isbn="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sblUrlFormatter() {
        return new SimpleUrlFormatter(
                "sbl.or.kr",
                "https://www.sbl.or.kr/dls_lt/index.php" + queryString_wdDataSearch_searchResultList(),
                Map.ofEntries(
                        Map.entry("사북공공도서관", "MA"),
                        Map.entry("정선꿈꾸는도서관", "SA"),
                        Map.entry("좋은씨앗작은도서관", "SB"),
                        Map.entry("다니엘작은도서관", "SC"),
                        Map.entry("꿈을파는작은도서관", "SF"),
                        Map.entry("길운도서관", "SH"),
                        Map.entry("아우라지작은도서관", "SI"),
                        Map.entry("무지개작은도서관", "SL"),
                        Map.entry("생각이자라는도서관", "SM"),
                        Map.entry("노엘작은도서관", "SN"),
                        Map.entry("꿈을심는작은도서관", "SO"),
                        Map.entry("행복한어린이작은도서관", "SP"),
                        Map.entry("꽃개비작은도서관", "SD"),
                        Map.entry("정선스마트도서관(종합)", "ZA"),
                        Map.entry("정선스마트도서관(아동)", "ZB"),
                        Map.entry("억새스마트도서관(종합)", "ZC"),
                        Map.entry("억새스마트도서관(아동)", "ZD")
                )
        );
    }

    @Bean
    public IsbnSearchUrlFormatter neutinamuUrlFormatter() {
        return new SimpleUrlFormatter(
                "neutinamu.org",
                "https://www.neutinamu.org/page/search/result.php?tsch="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter myclibUrlFormatter() {
        return new SimpleUrlFormatter(
                "myclib.or.kr",
                "https://www.myclib.or.kr/web/ksh/EgovBookSearchList.do?mnNo=301000000&schNm=",
                Map.of(),
                List.of("밀양시립영어도서관")
        );
    }

    @Bean
    public IsbnSearchUrlFormatter gjlibUrlFormatter() {
        return new SimpleUrlFormatter(
                "gjlib.go.kr",
                "https://www.gjlib.go.kr/BookSearch/simple" + "?"
        );
    }

    @Bean
    public IsbnSearchUrlFormatter sejongNlUrlFormatter() {
        return new SimpleUrlFormatter(
                "sejong.nl.go.kr",
                "https://sejong.nl.go.kr/search/searchStorage.do?upperMenuId=O200&menuId=O201&kwd="
        );
    }

    @Bean
    public IsbnSearchUrlFormatter jeonbukUrlFormatter() {
        return new SimpleUrlFormatter(
                "jeonbuk.go.kr",
                "https://library.jeonbuk.go.kr:8443/kolas3_01/BookSearch/search_result.do?jongbook=_book&buho1=SIB&msa=&formclass=&textlang=&simplelang=&mgc=MA&limitpage=10&buhovalue1="
        );
    }

    private static String queryString_jongbook_buhovalue() {
        return "?jongbook=&field1=IAL&value1=&aon1=AND&field2=IT&value2=&aon2=AND&field3=IA&value3=&aon3=AND&buho1=SIB&aon4=AND&buho2=KDC&buhovalue2=&aon5=AND&buhovalue3=&univname=&aon6=AND&buhovalue4=&govname=&sort=RK+DESC&msa=&formclass=&textlang=&simplelang=&startyear=&endyear=&limitpage=10&%EC%8B%A4local=+&startpage=1&mode=0&buhovalue1=";
    }

    private static String queryString_searchWordIsbn() {
        return "?searchType=DETAIL&searchRecordCount=30&searchLibrary=%s&searchWordIsbn=";
    }

    private static String queryString_wdDataSearch() {
        return "?mod=wdDataSearch&act=searchIList&serSec=detail&manageCode=%s&isbn=";
    }

    private static String queryString_wdDataSearch_NoRegion() {
        return "?mod=wdDataSearch&act=searchResultList&deSearch=1&isbn=";
    }

    private static String queryString_wdDataSearch_searchResultList() {
        return "?mod=wdDataSearch&act=searchResultList&manageCode=%s&isbn=";
    }

    private static String queryString_searchKeyword5() {
        return "?searchType=DETAIL&searchKey5=ISBN&searchRecordCount=30&searchLibrary=%s&searchKeyword5=";
    }


    private static String queryString_isbn_issn() {
        return "?g_page=search&m_page=search01&search_type=DETAIL&display=30&manage_code_detail=%s&search_isbn_issn=";
    }

    private static String queryString_isbn_issn_bookandnonbooksearch() {
        return "?detail=ok&cmd_name=bookandnonbooksearch&search_type=detail&manage_code=%s&search_isbn_issn=";
    }

}
