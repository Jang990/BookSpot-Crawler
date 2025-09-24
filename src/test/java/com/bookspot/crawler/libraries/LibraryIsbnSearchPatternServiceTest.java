package com.bookspot.crawler.libraries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryIsbnSearchPatternServiceTest {

    @Autowired
    private LibraryIsbnSearchPatternService service;

    @Autowired
    private LibraryIsbnSearchFileWriter writer;

    @Test
    void test() {
        List<LibraryIsbnSearchPattern> result = service.findAllPattern();
        assertEquals(result.size(), 1588);

        writer.write("files/libraryHomePages_Prod_Result.csv", result);
    }

}