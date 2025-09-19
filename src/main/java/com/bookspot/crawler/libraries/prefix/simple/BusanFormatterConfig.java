package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class BusanFormatterConfig {

    @Bean
    public IsbnSearchUrlFormatter commonBusanUrlFormatter() {
        return new IsbnSearchUrlFormatter() {
            @Override
            public String[] getDomains() {
                return BasicUrlFormatElements.toMultiDomain(
                        "bsnamgu.go.kr",
                        "geumjeong.go.kr",
                        "yeongdo.go.kr",
                        "guducklib.kr",
                        "sasang.go.kr",
                        "pen.go.kr",
                        "yeonje.go.kr",
                        "dongnae.go.kr",
                        "bsgangseo.go.kr",
                        "haeundae.go.kr",
                        "bsdonggu.go.kr",
                        "gijang.go.kr",
                        "www.busanlib.net",
                        "suyeong.go.kr"
                );
            }

            @Override
            public Map<String, String> getLibraryNameAndCode() {
                return Map.ofEntries(
                        Map.entry("부산광역시 분포도서관", "JT"),
                        Map.entry("부산광역시 남구도서관", "AQ"),

                        Map.entry("부산광역시 금정도서관", "AP"),
                        Map.entry("부산광역시 금샘도서관", "KF"),

                        Map.entry("부산광역시 영도도서관 남항분관", "BB"),
                        Map.entry("부산광역시 영도도서관", "AM"),

                        Map.entry("부산광역시립구덕도서관", "AA"),

                        Map.entry("부산광역시 사상도서관", "AW"),

                        Map.entry("부산광역시립반송도서관", "AC"),
                        Map.entry("부산영어도서관", "BA"),
                        Map.entry("부산광역시립부전도서관", "AD"),
                        Map.entry("부산광역시립구포도서관", "AB"),
                        Map.entry("부산광역시립해운대도서관", "BD"),
                        Map.entry("부산광역시립해운대도서관 우동분관", "AL"),
                        Map.entry("부산광역시립중앙도서관", "AK"),
                        Map.entry("부산광역시립중앙도서관 수정분관", "AH"),
                        Map.entry("부산광역시립명장도서관", "AN"),
                        Map.entry("부산광역시립사하도서관", "AE"),
                        Map.entry("부산광역시립서동도서관", "AF"),
                        Map.entry("부산광역시립시민도서관", "AG"),
                        Map.entry("부산광역시립연산도서관", "AJ"),

                        Map.entry("부산광역시 연제도서관", "BH"),

                        Map.entry("부산광역시 안락누리도서관", "BP"),
                        Map.entry("부산광역시 동래읍성도서관", "BK"),

                        Map.entry("신호작은도서관 아이들꿈자람터", "KJ"),
                        Map.entry("아이꿈 작은도서관", "KH"),
                        Map.entry("부산광역시 강서기적의도서관", "BQ"),
                        Map.entry("부산광역시 강서도서관", "AR"),
                        Map.entry("부산광역시 지사도서관", "CB"),

                        Map.entry("부산광역시 재송어린이도서관","AZ"),
                        Map.entry("부산광역시 반여도서관","AT"),
                        Map.entry("부산광역시 해운대인문학도서관","BR"),

                        Map.entry("부산광역시 동구어린이영어도서관","BT"),
                        Map.entry("부산광역시 동구도서관","AS"),

                        Map.entry("부산광역시 정관도서관", "BJ"),
                        Map.entry("부산광역시 기장도서관", "AX"),
                        Map.entry("부산광역시 고촌어울림도서관", "BZ"),
                        Map.entry("부산광역시 교리도서관", "KP"),
                        Map.entry("부산광역시 정관어린이도서관", "BG"),
                        Map.entry("부산광역시 내리새라도서관", "CA"),

                        Map.entry("부산광역시 대라다목적도서관", "BV"),

                        Map.entry("부산광역시 수영구도서관", "AV"),
                        Map.entry("부산광역시 망미도서관", "AY"),
                        Map.entry("부산광역시 수영구어린이도서관", "AO")
                );
            }

            @Override
            public String getTemplate() {
                return "https://library.busan.go.kr/gjbooks/book/search/collectionOfMaterials?search_txt=+&search_type=detail&option=0&procMode=search&pageno=1&search_field=search_title&display=50&manage_code=%s&search_isbn_issn=";
            }

            @Override
            public String format(LibraryPageDto dto) {
                if("부산광역시 기장디지털도서관".equals(dto.name()))
                    return null;
                return getTemplate().formatted(getLibraryCode(dto));
            }
        };
    }

    @Bean
    public IsbnSearchUrlFormatter sample() {
        return new SimpleUrlFormatter(
                "geumjeong.go.kr"
        );
    }

    /*
    dongnae.go.kr

    bsgangseo.go.kr
    busan.go.kr
    saha.go.kr
    bsbukgu.go.kr
    busanjin.go.kr
    geumjeong.go.kr
    haeundae.go.kr
     */
}
