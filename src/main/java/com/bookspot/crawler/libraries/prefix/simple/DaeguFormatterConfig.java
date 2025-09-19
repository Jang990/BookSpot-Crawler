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

                        "daegu.go.kr/beomeo", "daegu.go.kr/gosan", "daegu.go.kr/yonghak", // 수성구

                        "daegu.go.kr/bukgs", "daegu.go.kr/buktj", // 북구 (+ 태전)

                        "daegu.go.kr/junggu", // 중구

                        "daegu.go.kr/seogulib", // 서구

                        "daegu.go.kr/donggu", "donggu-lib.kr",  // 동구 (-lib는 앞에걸로 리다이렉트됨)
                        "www.dcasia.or.kr" // 동구 늘푸른 도서관

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
                        Map.entry("수성구립고산도서관", "BF"),
                        Map.entry("수성구립사월책문화센터도서관", "FG"),
                        Map.entry("수성구립무학숲도서관", "BH"),
                        Map.entry("수성구립용학도서관", "BE"),

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
                        Map.entry("한강공원부키 도서관", "HE"),

                        // 중구
                        Map.entry("삼덕마루 작은도서관", "HA"),
                        Map.entry("동인느티나무 도서관", "FQ"),
                        Map.entry("대봉2동 작은도서관", "HF"),
                        Map.entry("대신동 작은도서관", "GG"),
                        Map.entry("남산4동 작은도서관", "FF"),
                        Map.entry("대구 중구청 교양정보실", "FY"),
                        Map.entry("대구 중구 영어도서관", "FS"),

                        // 서구
                        Map.entry("대구 서구 비산도서관", "BQ"),
                        Map.entry("대구 서구 원고개도서관", "BN"),
                        Map.entry("대구 서구 영어도서관", "BP"),
                        Map.entry("대구 서구 어린이도서관", "BL"),
                        Map.entry("대구 서구 비원도서관", "BM"),
                        /*
                        "내당2,3동 드림도서관", "GQ"
                        "내당4동어린이도서관", "FU"
                        "비산7동 작은도서관", "FZ"
                        "새마을문고대구서구지부작은도서관", "FH"
                        "서구청작은도서관", "FT"
                        "달성토성마을 다락방 작은도서관", "HC"
                        "New평리도서관", "CC"
                        "서구어린이영어도서관", "HT"
                         */

                        // 동구
                        Map.entry("대구 동구 신천도서관", "CB"),
                        Map.entry("대구 동구 안심도서관", "CA"),
                        Map.entry("방촌동 작은도서관", "GX"),
                        Map.entry("해안동 작은도서관", "GY"),
                        Map.entry("신암2동 작은도서관", "GR"),
                        Map.entry("신암3동 작은도서관", "GS"),
                        Map.entry("효목2동 작은도서관", "FP"),
                        Map.entry("동촌역사 작은도서관", "GW"),
                        Map.entry("불로어울림 작은도서관", "GU"),
                        Map.entry("지저동 작은도서관", "GV"),
                        Map.entry("반야월 작은도서관", "FM"),
                        Map.entry("신천3동 작은도서관", "FK"),
                        Map.entry("도평동 작은도서관", "FL"),
                        Map.entry("효목1동 작은도서관", "GT"),
                        Map.entry("늘푸른 도서관", "HK")
                        /*
                        "행복작은도서관", "HN"

                        DB에 있긴한데 긴가민가...
                        "신암5동작은도서관", "HJ"           854
                        "율하5주민작은도서관", "HP"          1057
                        "꿈날자문고작은도서관", "HM"          326
                         */
                );
            }

            @Override
            public String format(LibraryPageDto dto) {
                if("노원동 작은도서관".equals(dto.name()))
                    return null;
                String homepage = dto.homePage();
                if(homepage.contains("donggu-lib.kr") || homepage.contains("dcasia.or.kr"))
                    homepage = "https://library.daegu.go.kr/donggu";

                Matcher m = Pattern.compile("kr/([^/]+)").matcher(homepage);
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
                        "daegu.go.kr/bukdh",
                        "daegu.go.kr/dalseong", // 달성 + 달성어린이
                        "daegu.go.kr/dongbu",
                        "daegu.go.kr/gw", // 삼국유사군위도서관
                        "daegu.go.kr/namdm", // 대명어울림도서관
                        "daegu.go.kr/namic", //이천어울림도서관
                        "daegu.go.kr/suseong" // 대구광역시립수성도서관
                );
            }

            @Override
            public String format(LibraryPageDto dto) {
                Matcher m = Pattern.compile("kr/([^/]+)").matcher(dto.homePage());
                if (!m.find())
                    throw new IllegalArgumentException(dto.toString());

                if (dto.name().equals("2.28도서관"))
                    return toTemplate(m.group(1), 125);
                if(dto.name().equals("달성어린이숲도서관"))
                    return toTemplate(m.group(1), 125);
                return toTemplate(m.group(1), 13);
            }

            private String toTemplate(String region, int menuIdx) {
                return "https://library.daegu.go.kr/%s/intro/search/index.do?menu_idx=%d&viewPage=1&booktype=BOOKANDNONBOOK&isbn="
                        .formatted(region, menuIdx);
            }
        };
    }

//    @Bean
    public IsbnSearchUrlFormatter daeguSampleUrlFormatter() {
        return new IsbnSearchUrlFormatter() {
            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain(
                        "daegu.go.kr",
                        "donggu-lib.kr",
                        "www.dcasia.or.kr"
                );
            }
        };
    }
}
