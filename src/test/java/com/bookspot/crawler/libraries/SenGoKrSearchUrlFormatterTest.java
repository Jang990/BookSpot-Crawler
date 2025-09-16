package com.bookspot.crawler.libraries;

import com.bookspot.crawler.libraries.formatter.SenGoKrSearchUrlFormatter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenGoKrSearchUrlFormatterTest {
    SenGoKrSearchUrlFormatter formatter = new SenGoKrSearchUrlFormatter();
    @Test
    void test() {
        assertEquals(
                "http://nwllc.sen.go.kr/nwllc/intro/search/index.do?menu_idx=4&editMode=normal&search_text=",
                formatter.format("http://nwllc.sen.go.kr/")
        );
        
        assertEquals(
                "https://gylib.sen.go.kr/gylib/intro/search/index.do?menu_idx=4&editMode=normal&search_text=",
                formatter.format("https://gylib.sen.go.kr")
        );
    }

}