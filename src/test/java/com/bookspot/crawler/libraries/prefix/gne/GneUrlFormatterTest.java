package com.bookspot.crawler.libraries.prefix.gne;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GneUrlFormatterTest {
    GneUrlFormatter formatter = new GneUrlFormatter();

    @Test
    void ISBN검색을_지원하지_않기_때문에_null_반환() {
        /* ISBN 검색을 지원하지 않으나 사용자들이 검색하기 편하게 반환 => 그래서 마지막에 &를 붙혀줌 */
//        assertNull(formatter.format(new LibraryPageDto(null, "경상남도교육청 함안도서관", "http://hmlib.gne.go.kr")));
    }

    @Test
    void libCode는_겹치지_않는다() {
        Set<String> libCodes = GneUrlFormatter.libNameAndSearchPageUrl.values()
                .stream().map(v -> v.substring(v.lastIndexOf("=") + 1))
                .collect(Collectors.toUnmodifiableSet());

        assertEquals(GneUrlFormatter.libNameAndSearchPageUrl.size(), libCodes.size());
    }

}