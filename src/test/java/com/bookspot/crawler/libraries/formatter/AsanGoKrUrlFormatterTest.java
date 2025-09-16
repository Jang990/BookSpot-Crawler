package com.bookspot.crawler.libraries.formatter;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsanGoKrUrlFormatterTest {
    AsanGoKrUrlFormatter formatter = new AsanGoKrUrlFormatter();

    @Test
    void 이름으로_구분한다() {
        // 중앙
        assertTrue(
                formatter.format(
                                new LibraryPageDto(null, "아산시 중앙도서관", null))
                        .contains("MF")
        );
        assertFalse(
                formatter.format(
                                new LibraryPageDto(null, "아산시 중앙도서관", null))
                        .contains("null")
        );

        // 꿈샘
        assertTrue(
                formatter.format(
                        new LibraryPageDto(null, "아산시 꿈샘어린이청소년도서관", null))
                        .contains("CH")
        );
        assertFalse(
                formatter.format(
                                new LibraryPageDto(null, "아산시 꿈샘어린이청소년도서관", null))
                        .contains("null")
        );
    }

    @Test
    void 존재하지_않는_도서관_코드는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.format(new LibraryPageDto(null, "", ""));
        });
    }

}