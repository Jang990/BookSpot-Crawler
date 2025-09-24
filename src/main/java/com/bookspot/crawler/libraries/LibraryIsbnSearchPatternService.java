package com.bookspot.crawler.libraries;

import com.bookspot.crawler.libraries.file.LibraryHomePagesFileReader;
import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;
import com.bookspot.crawler.libraries.prefix.ignore.IgnoreIsbnSearchUrlFormatter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryIsbnSearchPatternService {
    private final List<IsbnSearchUrlFormatter> searchUrlFormatters;
    private final List<LibraryPageDto> libraries;

    public LibraryIsbnSearchPatternService(
            List<IsbnSearchUrlFormatter> searchUrlFormatters,
            LibraryHomePagesFileReader libraryHomePagesFileReader
    ) {
        this.searchUrlFormatters = moveToLastIgnoreIsbnSearchUrlFormatter(searchUrlFormatters);
        this.libraries = libraryHomePagesFileReader.readLibrariesFromCsv("files/libraryHomePages_Prod.csv");
    }

    public List<LibraryIsbnSearchPattern> findAllPattern() {
        List<LibraryIsbnSearchPattern> result = new ArrayList<>();
        for (IsbnSearchUrlFormatter searchUrlFormatter : searchUrlFormatters) {
            List<LibraryPageDto> supportedLibraries = libraries.stream()
                    .filter(searchUrlFormatter::supports).toList();
            for (LibraryPageDto supportedLibrary : supportedLibraries) {
                result.add(
                        new LibraryIsbnSearchPattern(
                                supportedLibrary.id(),
                                supportedLibrary.name(),
                                searchUrlFormatter.format(supportedLibrary)
                        )
                );
            }
        }

        return result;
    }

    private List<IsbnSearchUrlFormatter> moveToLastIgnoreIsbnSearchUrlFormatter(List<IsbnSearchUrlFormatter> original) {
        List<IsbnSearchUrlFormatter> sorted = new ArrayList<>(original);

        IsbnSearchUrlFormatter ignore = sorted.stream()
                .filter(f -> f instanceof IgnoreIsbnSearchUrlFormatter)
                .findFirst()
                .orElseThrow();

        sorted.remove(ignore);
        sorted.add(ignore);
        return sorted;
    }
}
