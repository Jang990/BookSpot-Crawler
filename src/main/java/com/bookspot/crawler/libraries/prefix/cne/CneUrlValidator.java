package com.bookspot.crawler.libraries.prefix.cne;

import com.bookspot.crawler.libraries.prefix.IsbnUrlValidator;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;

@Slf4j
@Component
public class CneUrlValidator implements IsbnUrlValidator {

    @Override
    public boolean checkSearchPage(String prefix, String expectedIsbn, String targetSearchKind) throws IOException {
        String url = prefix + expectedIsbn;
        log.trace("페이지 확인 중: {}", url);

        try {
            // JSoup을 사용하여 페이지 파싱 (타임아웃 증가)
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                    .timeout(30000) // 30초로 증가
                    .get();

            boolean isbnFound = checkIsbnInput(doc, expectedIsbn);
            // 도서관 코드는 CSR.

            log.trace("ISBN ({}) 입력 상태: {}", expectedIsbn, isbnFound);

            boolean result = isbnFound;
            log.trace("최종 검사 결과: {}", result);

            return result;

        } catch (SocketTimeoutException e) {
            log.warn("타임아웃 발생: {}", prefix);
            throw e;
        }
    }

    private boolean checkIsbnInput(Document doc, String expectedIsbn) {
        log.trace("도서관 코드 확인 시작 (Asan #selManageCode): {}", expectedIsbn);

        Element select = doc.selectFirst("#content > p > em:nth-child(1)");
        if (select != null && expectedIsbn.equals(select.text())) {
            log.trace("#selManageCode에서 option 값 확인됨: {}", select.attr("checked"));
            return true;
        } else {
            log.warn("#selManageCode select 요소를 찾을 수 없음 | {}", expectedIsbn);
        }

        return false;
    }

}
