package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.ValidatorTestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleOcFormatterConfigTest {
    SimpleOcFormatterConfig config = new SimpleOcFormatterConfig();

    @Test
    void 옥천군_도서관() {
        assertEquals(1, count(config.ocUrlFormatter()));
    }

    @Test
    void 서대문구_도서관() {
        assertEquals(14, count(config.sdmUrlFormatter()));
    }

    @Test
    void 서울도서관_단일() {
        assertEquals(1, count(config.seoulUrlFormatter()));
    }

    @Test
    void 순창군도서관_단일_도서관선택_미지원() {
        assertEquals(1, count(config.sunchangUrlFormatter()));
    }

    @Test
    void 완주군립_도서관_도서관선택을_지원하나_맨뒤에_두는_방식이라_불가능() {
        assertEquals(5, count(config.wanjuUrlFormatter()));
    }

    @Test
    void 원주시립_도서관() {
        assertEquals(4, count(config.wonjuUrlFormatter()));
    }

    @Test
    void 양산시립_도서관() {
        assertEquals(9, count(config.yangsanUrlFormatter()));
    }

    @Test
    void 용인_도서관() {
        assertEquals(
                18,
                count(config.yonginUrlFormatter())
        );
    }

    @Test
    void 천안시_도서관() {
        assertEquals(
                8,
                count(config.cheonanUrlFormatter())
        );
    }

    @Test
    void 거창군립_도서관_ISBN미지원_단일도서관() {
        assertEquals(
                1,
                count(config.geochangUrlFormatter())
        );
    }

    @Test
    void 금산군() {
        assertEquals(5, count(config.geumsanUrlFormatter()));
    }

    @Test
    void 경주시립() {
        assertEquals(6, count(config.gyeongjuUrlFormatter()));
    }

    @Test
    void 연천군() {
        assertEquals(7, count(config.yeoncheonUrlFormatter()));
    }

    @Test
    void 포항() {
        assertEquals(41, count(config.pohangUrlFormatter()));
    }

    @Test
    void 서초구_도서관_선택_불가() {
        assertEquals(23, count(config.seocholibUrlFormatter()));
    }

    @Test
    void 안성시() {
        assertEquals(13, count(config.aplUrlFormatter()));
    }


    @Test
    void 인천_부평() {
        assertEquals(6, count(config.bpplUrlFormatter()));
    }

    @Test
    void 당진시립() {
        assertEquals(12, count(config.dangjinUrlFormatter()));
    }

    @Test
    void 경상북도() {
        assertEquals(27, count(config.gbelibUrlFormatter()));
    }

    @Test
    void 과천시정보과학도서관_단일() {
        assertEquals(1, count(config.gclibUrlFormatter()));
    }

    @Test
    void 강동구() {
        assertEquals(8, count(config.gdlibraryUrlFormatter()));
    }

    @Test
    void 김포() {
        assertEquals(11, count(config.gimpoUrlFormatter()));
    }

    @Test
    void 구리시립() {
        assertEquals(3, count(config.gurilibUrlFormatter()));
    }

    @Test
    void 서울_광진() {
        assertEquals(8, count(config.gwangjinlibUrlFormatter()));
    }

    @Test
    void 도봉구() {
        assertEquals(28, count(config.dobongUrlFormatter()));
    }

    @Test
    void 제주시_ISBN_미지원() {
        assertEquals(16, count(config.jejuUrlFormatter()));
    }

    @Test
    void 화성시립() {
        assertEquals(30, count(config.hscitylibUrlFormatter()));
    }

    @Test
    void 인천_서구() {
        assertEquals(6, count(config.isslUrlFormatter()));
    }

    @Test
    void 서울_중량() {
        assertEquals(6, count(config.jungnangUrlFormatter()));
    }

    @Test
    void 동대문구() {
        assertEquals(24, count(config.l4dUrlFormatter()));
    }

    @Test
    void 미추홀구() {
        assertEquals(6, count(config.michuhollUrlFormatter()));
    }

    @Test
    void 오산시() {
        assertEquals(7, count(config.osanUrlFormatter()));
    }

    @Test
    void 평창군립() {
        assertEquals(4, count(config.pcUrlFormatter()));
    }

    @Test
    void 대전서구_ISBN_검색미지원() {
        assertEquals(5, count(config.seoguUrlFormatter()));
    }

    @Test
    void 충남_서산() {
        assertEquals(7, count(config.seosanUrlFormatter()));
    }

    @Test
    void 신립() {
        assertEquals(5, count(config.seosanUrlFormatter()));
    }

    @Test
    void 송파() {
        assertEquals(12, count(config.spUrlFormatter()));
    }

    @Test
    void 수원시립_도서관분류_불가능() {
        assertEquals(20, count(config.suwonlibUrlFormatter()));
    }

    @Test
    void 통영() {
        assertEquals(4, count(config.tongyeonglibUrlFormatter()));
    }

    @Test
    void 의정부() {
        assertEquals(6, count(config.uilibUrlFormatter()));
    }

    @Test
    void 울산_남구() {
        assertEquals(4, count(config.ulsannamguUrlFormatter()));
    }

    @Test
    void 의왕시() {
        assertEquals(12, count(config.uwlibUrlFormatter()));
    }

    @Test
    void 여주시() {
        assertEquals(8, count(config.yjlibUrlFormatter()));
    }

    @Test
    void 양평군_도서관_구분_불가능() {
        assertEquals(6, count(config.yplibUrlFormatter()));
    }

    @Test
    void 여수시립() {
        assertEquals(7, count(config.yeosuUrlFormatter()));
    }

    @Test
    void 광주광역시_존재해도_결과가_안나옴() {
        assertEquals(3, count(config.gwangjuUrlFormatter()));
    }

    @Test
    void 김제시립() {
        assertEquals(10, count(config.gimjeUrlFormatter()));
    }

    @Test
    void 광명시() {
        assertEquals(6, count(config.gmUrlFormatter()));
    }

    @Test
    void 안동시립() {
        assertEquals(3, count(config.andongUrlFormatter()));
    }

    @Test
    void 안양시립() {
        assertEquals(11, count(config.anyangUrlFormatter()));
    }

    @Test
    void 광주_북구_ISBN검색_미지원() {
        assertEquals(5, count(config.gwangjuBukguUrlFormatter()));
    }

    @Test
    void 창원() {
        assertEquals(3, count(config.changwonUrlFormatter()));
    }

    @Test
    void 대전_대덕_ISBN검색_미지원() {
        assertEquals(3, count(config.daedeokUrlFormatter()));
    }

    @Test
    void 동두천() {
        assertEquals(3, count(config.ddcUrlFormatter()));
    }

    @Test
    void 동작구() {
        assertEquals(9, count(config.dongjakUrlFormatter()));
    }

    @Test
    void 충북_음성군() {
        assertEquals(4, count(config.eumseongUrlFormatter()));
    }

    @Test
    void 거제시립() {
        assertEquals(12, count(config.geojeUrlFormatter()));
    }

    @Test
    void 광주시립() {
        assertEquals(11, count(config.gjcityUrlFormatter()));
    }

    @Test
    void 경기도교육청() {
        assertEquals(11, count(config.goeUrlFormatter()));
    }

    @Test
    void 구로() {
        assertEquals(9, count(config.guroUrlFormatter()));
    }

    @Test
    void 강원도_교육청() {
        assertEquals(22, count(config.gweUrlFormatter()));
    }

    @Test
    void 인천교육청() {
        assertEquals(9, count(config.iceUrlFormatter()));
    }

    @Test
    void 익산시립() {
        assertEquals(7, count(config.iksanUrlFormatter()));
    }

    @Test
    void 전북교육청_ISBN검색_미지원() {
        assertEquals(18, count(config.jbeUrlFormatter()));
    }

    @Test
    void 진천군립() {
        assertEquals(3, count(config.jincheonUrlFormatter()));
    }

    @Test
    void 논산() {
        assertEquals(3, count(config.nonsanUrlFormatter()));
    }

    @Test
    void 파주시립() {
        assertEquals(22, count(config.pajuUrlFormatter()));
    }

    @Test
    void 포천시() {
        assertEquals(7, count(config.pocheonUrlFormatter()));
    }

    @Test
    void 세종시() {
        assertEquals(15, count(config.sejongUrlFormatter()));
    }

    @Test
    void 시흥시() {
        assertEquals(12, count(config.siheungUrlFormatter()));
    }

    @Test
    void 울진군() {
        assertEquals(8, count(config.uljinUrlFormatter()));
    }

    @Test
    void 양천구() {
        assertEquals(9, count(config.yangcheonUrlFormatter()));
    }

    @Test
    void 유성구_ISBN검색_미지원() {
        assertEquals(9, count(config.yuseongUrlFormatter()));
    }

    @Test
    void 청주() {
        assertEquals(15, count(config.cheongjuUrlFormatter()));
    }

    @Test
    void 칠곡군립() {
        assertEquals(3, count(config.chilgokUrlFormatter()));
    }

    @Test
    void 춘천시립() {
        assertEquals(8, count(config.chuncheonUrlFormatter()));
    }

    @Test
    void 울산_동구() {
        assertEquals(5, count(config.ulsanDongguUrlFormatter()));
    }

    @Test
    void 광주_서구_모든_검색이_CSR() {
        assertEquals(4, count(config.gwangjuSeoguUrlFormatter()));
    }

    @Test
    void 속초_시립() {
        assertEquals(2, count(config.sokchoUrlFormatter()));
    }

    @Test
    void 순천시립() {
        assertEquals(9, count(config.suncheonUrlFormatter()));
    }

    @Test
    void 마포() {
        assertEquals(15, count(config.mapoUrlFormatter()));
    }

    @Test
    void 노원_도서관_선택_불가능_CSR() {
        assertEquals(35, count(config.nowonlibUrlFormatter()));
    }

    @Test
    void 성남시() {
        assertEquals(19, count(config.snlibUrlFormatter()));
    }

    @Test
    void 울산_북구() {
        assertEquals(22, count(config.ulsanBukguUrlFormatter()));
    }

    @Test
    void 충주시립() {
        assertEquals(6, count(config.chungjuUrlFormatter()));
    }

    @Test
    void 단양군립() {
        assertEquals(2, count(config.danyangUrlFormatter()));
    }

    @Test
    void 가평군() {
        assertEquals(4, count(config.gaplibUrlFormatter()));
    }

    @Test
    void 강북() {
        assertEquals(7, count(config.gblibUrlFormatter()));
    }

    @Test
    void 고흥군립_ISBN검색_불가능() {
        assertEquals(3, count(config.ghlibUrlFormatter()));
    }

    @Test
    void 곡성_ISBN검색_불가능() {
        assertEquals(2, count(config.gokseongUrlFormatter()));
    }

    @Test
    void 공주시() {
        assertEquals(2, count(config.gongjulibUrlFormatter()));
    }

    @Test
    void 고양시() {
        assertEquals(26, count(config.goyanglibUrlFormatter()));
    }

    @Test
    void 하남시() {
        assertEquals(8, count(config.hanamlibUrlFormatter()));
    }

    @Test
    void 서울시_중구() {
        assertEquals(8, count(config.junggulibUrlFormatter()));
    }

    @Test
    void 양주시립() {
        assertEquals(10, count(config.libyjUrlFormatter()));
    }

    @Test
    void 목포() {
        assertEquals(4, count(config.mokpolibUrlFormatter()));
    }

    @Test
    void 인천_남동_도서관_선택불가능() {
        // https://alpasq.namdonglib.go.kr/search/keyword/9788936434120?manageCode=MB 이렇게해야만 가능함.
        assertEquals(3, count(config.namdonglibUrlFormatter()));
    }

    @Test
    void 남원() {
        assertEquals(3, count(config.namwonUrlFormatter()));
    }

    @Test
    void 평택() {
        assertEquals(14, count(config.ptlibUrlFormatter()));
    }

    @Test
    void 서울_성북구() {
        assertEquals(14, count(config.sblibUrlFormatter()));
    }

    @Test
    void 서울_성동구() {
        assertEquals(7, count(config.sdlibUrlFormatter()));
    }

    @Test
    void 태백시립() {
        assertEquals(2, count(config.taebaekUrlFormatter()));
    }

    @Test
    void 의성군_ISBN검색_도서관선택_불가능() {
        assertEquals(2, count(config.uscUrlFormatter()));
    }

    @Test
    void 서울시_영등포구() {
        assertEquals(7, count(config.ydplibUrlFormatter()));
    }

    @Test
    void 서울시_용산구() {
        assertEquals(16, count(config.yslibraryUrlFormatter()));
    }

    @Test
    void 충청남도_예산군() {
        assertEquals(2, count(config.ysplibUrlFormatter()));
    }

    @Test
    void 울산_울주군() {
        assertEquals(1, count(config.usulUrlFormatter()));
    }

    @Test
    void 울산_남부도서관() {
        assertEquals(1, count(config.usnlUrlFormatter()));
    }

    @Test
    void 울산_동부도서관() {
        assertEquals(1, count(config.usdlUrlFormatter()));
    }

    @Test
    void 태안군() {
        assertEquals(1, count(config.taeanUrlFormatter()));
    }

    @Test
    void 충북_제천시립() {
        // 제천시립도서관
        assertEquals(2, count(config.jecheonUrlFormatter()));
    }

    @Test
    void 인천_중구() {
        assertEquals(3, count(config.imlaUrlFormatter()));
    }

    @Test
    void 충남_부여군_홍산면() {
        assertEquals(1, count(config.hongsanlibUrlFormatter()));
    }

    @Test
    void 부천시_해밀() {
        assertEquals(1, count(config.hmlibUrlFormatter()));
    }

    @Test
    void 군포시_중앙도서관() {
        // 꽤 많음
        assertEquals(1, count(config.gunpolibUrlFormatter()));
    }

    @Test
    void 천안_아산_상생협력센터도서관() {
        assertEquals(1, count(config.capcUrlFormatter()));
    }

    @Test
    void 충청남도_서천_장항공공도서관() {
        assertEquals(1, count(config.seocheonUrlFormatter()));
    }

    @Test
    void 전북_무주군() {
        assertEquals(1, count(config.mujuUrlFormatter()));
    }

    @Test
    void 충청북도_증평군() {
        assertEquals(1, count(config.jpUrlFormatter()));
    }

    @Test
    void 강원도_정선군립() {
        assertEquals(1, count(config.jeongseonUrlFormatter()));
    }

    @Test
    void 전남_해남군립도서관() {
        assertEquals(1, count(config.haenamUrlFormatter()));
    }

    @Test
    void 충청북도_보은군립() {
        assertEquals(1, count(config.boeunUrlFormatter()));
    }

    @Test
    void 충북_제천시() {
        assertEquals(1, count(config.jccfreshUrlFormatter()));
    }

    @Test
    void 충남_홍성군() {
        assertEquals(1, count(config.hongseongUrlFormatter()));
    }

    @Test
    void 보령시_시립() {
        assertEquals(1, count(config.brcnUrlFormatter()));
    }

    @Test
    void 경상북도_영천시립() {
        assertEquals(1, count(config.yclibUrlFormatter()));
    }

    @Test
    void 강원도_정선군_사북공공도서관() {
        assertEquals(1, count(config.sblUrlFormatter()));
    }

    @Test
    void 경상남도_밀양시립() {
        assertEquals(2, count(config.myclibUrlFormatter()));
    }

    @Test
    void 전북_도청_도서관() {
    }

    // 단일검색은 기본적으로 도서관 선택 미지원
    @Test
    void 단일도서관() {
        // 남해화전도서관
        assertEquals(1, count(config.namhaeUrlFormatter()));

        // 함안군립칠원도서관
        assertEquals(1, count(config.hamanUrlFormatter()));

        // 경북도서관
        assertEquals(1, count(config.gbUrlFormatter()));

        // 대전 중구 한밭도서관 - ISBN 검색 미지원
        assertEquals(1, count(config.daejeonUrlFormatter()));

        // 창녕군 영산도서관
        assertEquals(1, count(config.cngUrlFormatter()));

        // 대전 서구 - 성남작은도서관 - ISBN 검색 미지원
        assertEquals(1, count(config.uLibraryUrlFormatter()));

        // 울산도서관
        assertEquals(1, count(config.ulsanUrlFormatter()));

        // 충남도서관 - ISBN 검색 미지원
        assertEquals(1, count(config.chungnamUrlFormatter()));

        // 세종평생교육학습관
        assertEquals(1, count(config.sjeUrlFormatter()));

        // 전라남도 도립 도서관(전라남도립도서관)
        assertEquals(1, count(config.jeonnamUrlFormatter()));

        // 경남대표도서관
        assertEquals(1, count(config.gyeongnamUrlFormatter()));

        // 충남도서관 - ISBN 검색 미지원
        assertEquals(1, count(config.guryeUrlFormatter()));

        // 인천 꿈벗도서관
        assertEquals(1, count(config.kblibUrlFormatter()));

        // 전북 신안군립 도서관
        assertEquals(1, count(config.shinanUrlFormatter()));

        // 느티나무 도서관 - 경기도 용인시
        assertEquals(1, count(config.neutinamuUrlFormatter()));

        // 전라남도 강진군 도서관 - ISBN 검색 미지원
        assertEquals(1, count(config.gjlibUrlFormatter()));

        // 국립세종도서관
        assertEquals(1, count(config.sejongNlUrlFormatter()));

        // 전북도청도서관
        assertEquals(1, count(config.jeonbukUrlFormatter()));
    }

    private long count(IsbnSearchUrlFormatter formatter) {
        return ValidatorTestRunner.countRelatedLibrary(formatter);
    }


/*
    @Test
    void t() {
        ValidatorTestRunner.countRelatedLibrary(config.sdmUrlFormatter());
    }
*/



}