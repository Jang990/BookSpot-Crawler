package com.bookspot.crawler.libraries.file;

import java.util.Objects;

public record LibraryPageDto(Long id, String name, String homePage) {
    public LibraryPageDto {
        Objects.requireNonNull(homePage);
    }
}
