package com.bookspot.crawler.libraries;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class LibraryIsbnSearchFileWriter {

    public void write(String filePath, List<LibraryIsbnSearchPattern> libraries) {
        // CSV 파일 생성
        Path outputPath = Paths.get(filePath);
        try (OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream(outputPath.toFile()),
                StandardCharsets.UTF_8
        );
             BufferedWriter writer = new BufferedWriter(osw)) {

            writer.write('\uFEFF'); // BOM 추가

            // 헤더 작성
            writer.write("id,name,home_page,isbn_search_prefix");
            writer.newLine();

            // 데이터 작성
            for (LibraryIsbnSearchPattern lib : libraries) {
                writer.write(
                        lib.id() + "," +
                                lib.name() + "," +
                                (lib.format() == null ? "" : lib.format())
                );
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("CSV 파일 생성 실패", e);
        }
    }
}
