package com.bookspot.crawler.libraries.file;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class LibraryHomePagesFileReaderTest {
    LibraryHomePagesFileReader reader = new LibraryHomePagesFileReader();

    @Test
    void test() {
        List<LibraryPageDto> dtos = reader.readLibrariesFromCsv("files/libraryHomePages_Prod.csv");
        assertEquals(1587, dtos.size());
    }
}