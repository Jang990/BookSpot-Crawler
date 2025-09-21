package com.bookspot.crawler.libraries.prefix;

import com.bookspot.crawler.libraries.file.LibraryHomePagesFileReader;
import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.ignore.IgnoreIsbnSearchUrlFormatter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTestRunner {
    static String[] expectedIsbn13Array = {
            "9788936434120" // 소년이 온다
//            "9791168418011" // 흔한남매. 16
    };

    static LibraryHomePagesFileReader reader = new LibraryHomePagesFileReader();
    public static List<LibraryPageDto> csvData = reader.readLibrariesFromCsv("files/libraryHomePages_Prod.csv");
    static List<String> ignoreUrlList = IgnoreIsbnSearchUrlFormatter.WHITE_LIST;
    static IgnoreIsbnSearchUrlFormatter ignoreFormatter = new IgnoreIsbnSearchUrlFormatter();

    public static void run(int relatedLibraryCount, IsbnSearchUrlFormatter formatter, IsbnUrlValidator validator) {
        List<LibraryPageDto> relatedLibraries = csvData.stream()
                .filter(dto -> !ignoreFormatter.supports(dto))
                .filter(formatter::supports)
                .toList();
        assertEquals(relatedLibraryCount, relatedLibraries.size());

        List<LibraryPageDto> unsupportedLibraries = relatedLibraries.stream()
                .filter(dto -> !ignoreUrlList.contains(dto.homePage()))
                .filter(dto -> {
                    try {
                        String code = formatter.getLibraryCode(dto);
                        String prefix = formatter.format(dto);
                        for (String expectedIsbn13 : expectedIsbn13Array) {
                            System.out.println(dto.name() + " | " + prefix + expectedIsbn13);
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

    public static long countRelatedLibrary(IsbnSearchUrlFormatter formatter) {
        long size = csvData.stream().filter(formatter::supports).count();
        System.out.println("size = " + size);

        List<LibraryPageDto> unsupported = new ArrayList<>();
        for (LibraryPageDto lib : csvData) {
            if(!formatter.supports(lib))
                continue;
            try{
                System.out.println(lib.name() + " | " + lib.homePage() + " | " + formatter.format(lib) + expectedIsbn13Array[0]);
            } catch (IllegalArgumentException e) {
                unsupported.add(lib);
            }
        }

        if(unsupported.isEmpty())
            return size;
        System.out.println("지원하지 않는 도서관 = " + unsupported.stream().map(LibraryPageDto::name).toList());
        throw new IllegalArgumentException();
    }
}
