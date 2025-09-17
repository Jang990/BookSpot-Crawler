package com.bookspot.crawler.libraries.prefix.jne;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JneGoKrIsbnSearchUrlFormatterTest {
    JneGoKrIsbnSearchUrlFormatter formatter = new JneGoKrIsbnSearchUrlFormatter();

    @Test
    void test() {
        // 벌교
        assertEquals(
                "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=00146013&vSrchText0=",
                formatter.format(new LibraryPageDto(null, null, "http://bglib.jne.go.kr/"))
        );

        // 보성
        assertEquals(
                "https://bglib.jne.go.kr/book/search_book/search.es?mid=a90101010100&searchKind=00146012&vSrchText0=",
                formatter.format(new LibraryPageDto(null, null, "http://bslib.jne.go.kr/"))
        );
    }

    @Test
    void value_중복_불가능() {
        Map<String, String> map = JneGoKrIsbnSearchUrlFormatter.homePageAndCode;

        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            assertTrue(values.add(value), "Duplicate value found: " + value);
        }
    }

}