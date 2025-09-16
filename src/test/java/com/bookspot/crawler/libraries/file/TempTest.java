package com.bookspot.crawler.libraries.file;

import com.bookspot.crawler.libraries.IsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.JneGoKrIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.validator.IsbnUrlValidator;
import com.bookspot.crawler.libraries.validator.JneGoKrUrlValidator;
import com.bookspot.crawler.libraries.SenGoKrSearchUrlFormatter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TempTest {
    LibraryHomePagesFileReader reader = new LibraryHomePagesFileReader();

    String expectedIsbn13 = "9788936434120"; // 소년이 온다

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
                        return !validator.checkSearchPage(prefix, expectedIsbn13, code);
                    } catch (IllegalArgumentException e) {
                        return true;
                    } catch (IOException e) {
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
                Arguments.of("전라남도 도서관 검증", 21, new JneGoKrIsbnSearchUrlFormatter(), new JneGoKrUrlValidator())
//                Arguments.of("서울 도서관 검증", 23, new SenGoKrSearchUrlFormatter())
        );
    }
}
