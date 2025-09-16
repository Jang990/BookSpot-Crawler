package com.bookspot.crawler.libraries.validator;

import com.bookspot.crawler.libraries.file.LibraryHomePagesFileReader;
import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.formatter.IsbnSearchUrlFormatter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTestRunner {
    static String[] expectedIsbn13Array = {
            "9788936434120" // 소년이 온다
//            "9791168418011" // 흔한남매. 16
    };

    static LibraryHomePagesFileReader reader = new LibraryHomePagesFileReader();
    static List<LibraryPageDto> csvData = reader.readLibrariesFromCsv("files/libraryHomePages_Prod.csv");

    static void run(int relatedLibraryCount, IsbnSearchUrlFormatter formatter, IsbnUrlValidator validator) {
        List<LibraryPageDto> relatedLibraries = csvData.stream()
                .filter(formatter::supports)
                .toList();
        assertEquals(relatedLibraryCount, relatedLibraries.size());

        List<LibraryPageDto> unsupportedLibraries = relatedLibraries.stream()
                .filter(dto -> {
                    try {
                        String code = formatter.getLibraryCode(dto);
                        String prefix = formatter.format(dto);
                        System.out.println(dto.name() + " | " + prefix);
                        for (String expectedIsbn13 : expectedIsbn13Array) {
                            if(validator.checkSearchPage(prefix, expectedIsbn13, code))
                                return false;
                        }
                        throw new IllegalArgumentException("ISBN 책 데이터 검증 실패함");
                    } catch (IllegalArgumentException | IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        for (LibraryPageDto unsupportedLibrary : unsupportedLibraries) {
            System.out.println(unsupportedLibrary);
        }
        assertTrue(unsupportedLibraries.isEmpty());
    }
}
