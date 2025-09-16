package com.bookspot.crawler.libraries;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.formatter.SenGoKrSearchUrlFormatter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenGoKrSearchUrlFormatterTest {
    SenGoKrSearchUrlFormatter formatter = new SenGoKrSearchUrlFormatter();
    @Test
    void test() {
        // 노원평생학습관
        assertEquals(
                "http://nwllc.sen.go.kr/nwllc/intro/search/index.do?menu_idx=4&editMode=normal&search_text=",
                formatter.format(new LibraryPageDto(null, null, "http://nwllc.sen.go.kr/"))
        );

        // 강서
        assertEquals(
                "https://gylib.sen.go.kr/gylib/intro/search/index.do?menu_idx=4&editMode=normal&search_text=",
                formatter.format(new LibraryPageDto(null, null, "https://gylib.sen.go.kr/"))
        );
    }

}