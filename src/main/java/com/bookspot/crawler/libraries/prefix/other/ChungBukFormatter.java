package com.bookspot.crawler.libraries.prefix.other;

import com.bookspot.crawler.libraries.file.LibraryPageDto;
import com.bookspot.crawler.libraries.prefix.IsbnSearchUrlFormatter;

import java.util.Map;

public class ChungBukFormatter implements IsbnSearchUrlFormatter {

    @Override
    public String[] getDomains() {
        return new String[]{
                "http://www.cbelib.go.kr", // 충청북도교육도서관
                "http://cbec.go.kr/", // 충청북도교육문화원
                "http://www.jwec.go.kr/", // 충청북도중원교육문화원
                "http://www.jwelib.go.kr/", // 중원교육도서관
                "http://www.jcsh.go.kr/", // 제천학생
                "https://www.mwelib.go.kr", // 미원교육
                "http://www.beelib.go.kr/", // 보은교육

                "http://www.ocelib.go.kr/", // 옥천교육도서관
                "http://www.ydelib.go.kr/", // 영동교육도서관
                "http://www.jcelib.go.kr/", // 진천교육도서관
                "http://www.gselib.go.kr/", // 괴산교육도서관
                "http://www.jpelib.go.kr", // 증평교육도서관
                "http://www.eselib.go.kr/", // 음성교육도서관
                "http://www.gwelib.go.kr/", // 금왕교육도서관
                "http://dyelib.go.kr/" // 단양교육도서관

        };
    }

    @Override
    public Map<String, String> getLibraryNameAndCode() {
        return Map.ofEntries(
                Map.entry("충청북도교육도서관", "MA"),
                Map.entry("충청북도교육문화원", "MB"),
                Map.entry("충청북도중원교육문화원", "MC"),
                Map.entry("중원교육도서관", "MD"),
                Map.entry("제천학생회관", "ME"),
                Map.entry("미원교육도서관", "MF"),
                Map.entry("보은교육도서관", "MG"),
                Map.entry("옥천교육도서관", "MH"),
                Map.entry("영동교육도서관", "MI"),
                Map.entry("진천교육도서관", "MJ"),
                Map.entry("괴산교육도서관", "MK"),
                Map.entry("증평교육도서관", "ML"),
                Map.entry("음성교육도서관", "MM"),
                Map.entry("금왕교육도서관", "MN"),
                Map.entry("단양교육도서관", "MO")
        );
    }

    @Override
    public String getTemplate() {
        // ISBN 검색 미지원
        return "https://www.cbelib.go.kr:7443/dls_le/index.php?manageCode=%s&siteId=SITE_000000000000002" + "&";
    }
}
