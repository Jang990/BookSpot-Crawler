package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GimhaeUrlFormatter implements IsbnSearchUrlFormatter {
    Map<String, DongAndCode> map = Map.ofEntries(
            Map.entry("김해율하도서관", new DongAndCode(0, "YH")),
            Map.entry("칠암도서관", new DongAndCode(0, "CA")),
            Map.entry("진영한빛도서관", new DongAndCode(0, "JH")),
            Map.entry("화정글샘도서관", new DongAndCode(0, "HJ")),
            Map.entry("장유도서관", new DongAndCode(0, "JY")),
            Map.entry("김해기적의도서관", new DongAndCode(0, "KG")),
            Map.entry("생각이크는작은도서관", new DongAndCode(1, "SG")),
            Map.entry("글혜윰작은도서관", new DongAndCode(1, "GH")),
            Map.entry("중흥샘이깊은작은도서관", new DongAndCode(1, "JS")),
            Map.entry("김해글로벗도서관", new DongAndCode(1, "DM")),
            Map.entry("주촌디딤돌작은도서관", new DongAndCode(13, "JC")),
            Map.entry("진례작은도서관", new DongAndCode(3, "JR")),
            Map.entry("한림미래작은도서관", new DongAndCode(4, "SH")),
            Map.entry("대포천작은도서관", new DongAndCode(9, "DP")),
            Map.entry("대동푸른뜰작은도서관", new DongAndCode(11, "BJ")),
            Map.entry("캐슬작은도서관", new DongAndCode(5, "KS")),
            Map.entry("소리작은도서관", new DongAndCode(10, "SL")),
            Map.entry("한국작은도서관", new DongAndCode(6, "HK")),
            Map.entry("대동한마음작은도서관", new DongAndCode(6, "DD")),
            Map.entry("덕산작은도서관", new DongAndCode(6, "DS")),
            Map.entry("한신책사랑작은도서관", new DongAndCode(6, "HC")),
            Map.entry("뜨란채작은도서관", new DongAndCode(6, "DR")),
            Map.entry("내외작은도서관", new DongAndCode(6, "NO")),
            Map.entry("일동한신꿈나무작은도서관", new DongAndCode(6, "IH")),
            Map.entry("삼계푸르지오작은도서관", new DongAndCode(7, "SK")),
            Map.entry("하늘빛작은도서관", new DongAndCode(7, "HN")),
            Map.entry("김해청소년문화의집", new DongAndCode(7, "KM")),
            Map.entry("삼계로얄작은도서관", new DongAndCode(7, "SR")),
            Map.entry("분성IPARK작은도서관", new DongAndCode(7, "BI")),
            Map.entry("이안나누리작은도서관", new DongAndCode(7, "EA")),
            Map.entry("U보라작은도서관", new DongAndCode(12, "BR")),
            Map.entry("유토피아작은도서관", new DongAndCode(14, "UT")),
            Map.entry("활천행복작은도서관", new DongAndCode(14, "HH")),
            Map.entry("불암동작은도서관", new DongAndCode(8, "BA")),
            Map.entry("월산주공작은도서관", new DongAndCode(15, "WS")),
            Map.entry("책고래작은도서관", new DongAndCode(15, "CK")),
            Map.entry("석봉마을작은도서관", new DongAndCode(15, "SB")),
            Map.entry("젤미작은도서관", new DongAndCode(16, "JM")),
            Map.entry("우리작은도서관", new DongAndCode(16, "WR")),
            Map.entry("장유대우작은도서관", new DongAndCode(16, "JD")),
            Map.entry("팔판작은도서관", new DongAndCode(17, "PP")),
            Map.entry("리첼작은도서관", new DongAndCode(17, "RC")),
            Map.entry("떡갈나무숲작은도서관", new DongAndCode(17, "DG")),
            Map.entry("율하e편한작은도서관", new DongAndCode(17, "UE")),
            Map.entry("팔판빛오름작은도서관", new DongAndCode(17, "PB"))
    );

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain("gimhae.go.kr");
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return map.entrySet().stream().collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().code()
                )
        );
    }

    @Override
    public String format(LibraryPageDto dto) {
        return "http://libbook.gimhae.go.kr:8000/bookv2/smartlib/list.php?dong=%d&mgns[]=%s&buho1=ISBN&buho1value=".formatted(
                map.get(dto.name()).dong(),
                map.get(dto.name()).code()
        );
    }

    private record DongAndCode(int dong, String code) { }
}
