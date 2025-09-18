package com.bookspot.crawler.libraries.prefix;

import java.util.Map;

public interface BasicUrlFormatElements {
    static String[] toSingleDomain(String domain) {
        return new String[]{domain};
    }

    static String[] toMultiDomain(String... domains) {
        return domains;
    }


    /**
     * 공통 도메인
     * ex) sen.go.kr
    */
    String[] getDomains();

    /**
     * 도서관 이름 - 코드
     * ex) "아산시 중앙도서관", "MF"
     *
     * 코드가 존재하지 않는 별개의 도서관이라면 null 반환
     * 코드가 존재한다면 Map을 구현할 것
     *
     * 하위에서 getLibraryCode에서 사용
     */
    default Map<String, String> getLibraryNameAndCode() {
        return null;
    }

    /**
     * 도서관 템플릿
     *
     * null인 경우 : format을 직접 구현할 것
     * null이 아닌 경우: 디폴트 메서드 사용가능
     */
    default String getTemplate() {
        return null;
    }
}
