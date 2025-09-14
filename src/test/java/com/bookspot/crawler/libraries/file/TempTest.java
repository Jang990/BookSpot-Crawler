package com.bookspot.crawler.libraries.file;

import com.bookspot.crawler.libraries.JneGoKrIsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.JneGoKrUrlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TempTest {
    LibraryHomePagesFileReader reader = new LibraryHomePagesFileReader();
    JneGoKrIsbnSearchUrlFormatter formatter = new JneGoKrIsbnSearchUrlFormatter();
    JneGoKrUrlValidator validator = new JneGoKrUrlValidator();

    String expectedIsbn13 = "9788936434120"; // 소년이 온다

    @Test
    void 전라남도_도서관_검증_29() {
        List<LibraryPageDto> result = reader.readLibrariesFromCsv("files/libraryHomePages_Prod.csv");
        List<LibraryPageDto> unsupportedLibraries = result.stream()
                .filter(dto -> formatter.supports(dto.homePage()))
                .filter(dto -> {
                    try {
                        String prefix = formatter.format(dto.homePage());
                        String code = JneGoKrIsbnSearchUrlFormatter.homePageAndCode.get(dto.homePage());
                        validator.checkSearchPage(prefix, expectedIsbn13, code);
                        return false;
                    } catch (IllegalArgumentException e) {
                        return true;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        assertTrue(unsupportedLibraries.isEmpty());
    }
}
