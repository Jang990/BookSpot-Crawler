package com.bookspot.crawler.libraries.file;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryHomePagesFileReader {
    public List<LibraryPageDto> readLibrariesFromCsv(String filePath) {
        Path path = Paths.get(filePath);
        List<LibraryPageDto> result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // 헤더 건너뜀
                }

                String[] tokens = line.split(",", -1); // 빈 값도 유지
                Long id = Long.parseLong(tokens[0]);
                String name = tokens[1];
                String homePage = tokens[2];

                result.add(new LibraryPageDto(id, name, homePage));
            }
        } catch (IOException e) {
            throw new IllegalStateException("CSV 읽기 실패", e);
        }

        return result;
    }
}
