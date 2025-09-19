package com.bookspot.crawler.libraries.prefix.simple;

import com.bookspot.crawler.libraries.prefix.ValidatorTestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusanFormatterConfigTest {
    BusanFormatterConfig config = new BusanFormatterConfig();

    @Test
    void 부산_도서관_ISBN검색_불가능_도서관_선택_가능() {
        ValidatorTestRunner.countRelatedLibrary(config.commonBusanUrlFormatter());
    }

}