package com.bookspot.crawler.libraries.prefix.cne;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CneUrlFormatterTest {
    CneUrlFormatter formatter = new CneUrlFormatter();

    @Test
    void test() {
        assertEquals(
                "https://yslib.cne.go.kr/api/srch/bookSearch.do?searchCondition=ALL&searchTxt=",
                formatter.format(new LibraryPageDto(null, null, "https://yslib.cne.go.kr/"))
        );

        assertEquals(
                "https://uclib.cne.go.kr/api/srch/bookSearch.do?searchCondition=ALL&searchTxt=",
                formatter.format(new LibraryPageDto(null, null, "https://uclib.cne.go.kr"))
        );
    }

}