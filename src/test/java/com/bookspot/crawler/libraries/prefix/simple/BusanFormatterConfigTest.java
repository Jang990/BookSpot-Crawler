package com.bookspot.crawler.libraries.prefix.simple;

import org.junit.jupiter.api.Test;

import static com.bookspot.crawler.libraries.prefix.ValidatorTestRunner.*;
import static org.junit.jupiter.api.Assertions.*;

class BusanFormatterConfigTest {
    BusanFormatterConfig config = new BusanFormatterConfig();

    @Test
    void 부산_도서관_ISBN검색_불가능_도서관_선택_가능() {
        countRelatedLibrary(config.commonBusanUrlFormatter());
    }

    @Test
    void sample() {
        countRelatedLibrary(config.sample());
    }

}