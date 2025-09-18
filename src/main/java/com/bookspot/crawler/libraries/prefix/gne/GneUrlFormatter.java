package com.bookspot.crawler.libraries.prefix.gne;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.BasicUrlFormatElements;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class GneUrlFormatter implements IsbnSearchUrlFormatter {
    private static final String DOMAIN = "gne.go.kr";
    protected static final Map<String, String> libNameAndSearchPageUrl = Map.ofEntries(
            Map.entry("경상남도교육청 창원도서관", "https://cwlib.gne.go.kr/book/search.es?mid=a20301010000"),
            Map.entry("경상남도교육청 거창도서관", "https://gclib.gne.go.kr/book/search.es?mid=b90101000000"),
            Map.entry("경상남도교육청 김해지혜의바다도서관", "https://ghjhlib.gne.go.kr/book/search.es?mid=d20201000000"),
            Map.entry("경상남도교육청 함안도서관", "https://hmlib.gne.go.kr/book/search.es?mid=a70201000000"),
            Map.entry("경상남도교육청 진동도서관", "https://jdlib.gne.go.kr/book/search.es?mid=b60201010000"),
            Map.entry("경상남도교육청 마산도서관", "https://mslib.gne.go.kr/book/search.es?mid=a40101000000"),
            Map.entry("경상남도교육청 사천도서관", "https://salib.gne.go.kr/book/search.es?mid=c20201000000"),
            Map.entry("경상남도교육청 삼천포도서관", "https://scplib.gne.go.kr/book/search.es?mid=a60101000000"),
            Map.entry("경상남도교육청 의령도서관", "https://urlib.gne.go.kr/book/search.es?mid=c50201000000"),
            Map.entry("경상남도교육청 창녕도서관", "https://cnlib.gne.go.kr/book/search.es?mid=c30201000000"),
            Map.entry("경상남도교육청 김해도서관", "https://ghlib.gne.go.kr/book/search.es?mid=a30301000000"),
            Map.entry("경상남도교육청 거제도서관", "https://gjlib.gne.go.kr/book/search.es?mid=c70201000000"),
            Map.entry("경상남도교육청 고성도서관", "https://gslib.gne.go.kr/book/search.es?mid=b30204000000"),
            Map.entry("경상남도교육청 합천도서관", "https://hclib.gne.go.kr/book/search.es?mid=b80401000000"),
            Map.entry("경상남도교육청 하동도서관", "https://hdlib.gne.go.kr/book/search.es?mid=a50201000000"),
            Map.entry("경상남도교육청 하남도서관", "https://hnlib.gne.go.kr/book/search.es?mid=b50301000000"),
            Map.entry("경상남도교육청 함양도서관", "https://hylib.gne.go.kr/book/search.es?mid=a80201000000"),
            Map.entry("경상남도교육청 마산지혜의바다도서관", "https://jhlib.gne.go.kr/book/search.es?mid=d10701000000"),
            Map.entry("경상남도교육청 진양도서관", "https://jinlib.gne.go.kr/book/search.es?mid=b40101000000"),
            Map.entry("경상남도교육청 진영도서관", "https://jylib.gne.go.kr/book/search.es?mid=a90101000000"),
            Map.entry("경상남도교육청 밀양도서관", "https://mrlib.gne.go.kr/book/search.es?mid=b70201000000"),
            Map.entry("경상남도교육청 남해도서관", "https://nhlib.gne.go.kr/book/search.es?mid=c10501000000"),
            Map.entry("경상남도교육청 남지도서관", "https://njlib.gne.go.kr/book/search.es?mid=c40201000000"),
            Map.entry("경상남도교육청 산청도서관", "https://sanlib.gne.go.kr/book/search.es?mid=c60201000000"),
            Map.entry("경상남도교육청 산청지리산도서관", "https://sjlib.gne.go.kr/book/search.es?mid=d30201000000"),
            Map.entry("경상남도교육청 통영도서관", "https://tylib.gne.go.kr/book/search.es?mid=b20201000000"),
            Map.entry("경상남도교육청 양산도서관", "https://yslib.gne.go.kr/book/search.es?mid=b10201000000")
    );

    /*
    https://cwlib.gne.go.kr/book/search.es?mid=a20301010000
    ISBN13 검색을 지원하지 않음.
     */

    @Override
    public String[] getDomains() {
        return BasicUrlFormatElements.toSingleDomain(DOMAIN);
    }

    @Override
    public String format(LibraryPageDto dto) {
        String searchPageUrl = libNameAndSearchPageUrl.get(dto.name());
        if(searchPageUrl == null)
            throw new IllegalArgumentException("지원하지 않는 dto = " + dto);
        return searchPageUrl + "&";
    }
}
