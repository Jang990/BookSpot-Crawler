package com.bookspot.crawler.libraries.file;

import com.bookspot.crawler.libraries.formatter.IsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.validator.IsbnUrlValidator;
import com.bookspot.crawler.libraries.formatter.SenGoKrSearchUrlFormatter;
import com.bookspot.crawler.libraries.validator.SenGoKrUrlValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TempTest {
    LibraryHomePagesFileReader reader = new LibraryHomePagesFileReader();

    String[] expectedIsbn13Array = {
            "9788936434120" // 소년이 온다
//            "9791168418011" // 흔한남매. 16
    };

    List<LibraryPageDto> csvData = reader.readLibrariesFromCsv("files/libraryHomePages_Prod.csv");


    @ParameterizedTest(name = "{0}")
    @MethodSource("libraryTestData")
    void test(String title, int relatedLibraryCount, IsbnSearchUrlFormatter formatter, IsbnUrlValidator validator) {
        List<LibraryPageDto> relatedLibraries = csvData.stream()
                .filter(dto -> formatter.supports(dto.homePage()))
                .toList();
        assertEquals(relatedLibraryCount, relatedLibraries.size());

        List<LibraryPageDto> unsupportedLibraries = relatedLibraries.stream()
                .filter(dto -> {
                    try {
                        String code = formatter.getLibraryCode(dto.homePage());
                        String prefix = formatter.format(dto.homePage());
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

    private static Stream<Arguments> libraryTestData() {
        return Stream.of(
//                Arguments.of("전라남도 도서관 검증", 21, new JneGoKrIsbnSearchUrlFormatter(), new JneGoKrUrlValidator())
                Arguments.of("서울 도서관 검증", 23, new SenGoKrSearchUrlFormatter(), new SenGoKrUrlValidator())
        );
    }
}
