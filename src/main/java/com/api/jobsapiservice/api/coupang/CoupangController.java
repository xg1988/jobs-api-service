package com.api.jobsapiservice.api.coupang;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.dto.Message;
import com.api.jobsapiservice.dto.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 쿠팡 파트너스 API 연동
 */
@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value = "/coupang")
@Slf4j
public class CoupangController {

    private final CoupangServiceImpl coupangService;

    public CoupangController(CoupangServiceImpl coupangService) {
        this.coupangService = coupangService;
    }

    /**
     * 쿠팡 키워드 검색
     * @param keyword
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/search/{keyword}")
    public ResponseEntity search(@PathVariable String keyword) throws IOException {
        log.debug("keyword:{}", keyword);

        CoupangSearchDto coupangSearchDto = coupangService.search(keyword, 10);

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType(BaseConst.DEFAULT_CONTENT_TYPE
                , BaseConst.DEFAULT_SUB_TUPE
                , Charset.forName(BaseConst.DEFAULT_CHAR_SET)));

        return new ResponseEntity<>(new Message().builder()
                .status(StatusEnum.OK)
                .message("성공")
                .data(coupangSearchDto.getData()).build(), headers, HttpStatus.OK);
    }

    /**
     * 쿠팡 골드박스 검색
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/goldbox")
    public ResponseEntity goldbox() throws IOException {

        CoupangDto coupangDto = coupangService.goldbox();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType(BaseConst.DEFAULT_CONTENT_TYPE
                , BaseConst.DEFAULT_SUB_TUPE
                , Charset.forName(BaseConst.DEFAULT_CHAR_SET)));

        return new ResponseEntity<>(new Message().builder()
                .status(StatusEnum.OK)
                .message("성공")
                .data(coupangDto.getData()).build(), headers, HttpStatus.OK);
    }

    /**
     * 쿠팡 카테고리 검색
     * @param categoryId
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/bestcategories/{categoryId}")
    public ResponseEntity bestcategories(@PathVariable String categoryId) throws IOException {
        log.debug("categoryId:{}", categoryId);
        CoupangDto coupangDto = coupangService.bestcategories(categoryId, 10);

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType(BaseConst.DEFAULT_CONTENT_TYPE
                , BaseConst.DEFAULT_SUB_TUPE
                , Charset.forName(BaseConst.DEFAULT_CHAR_SET)));

        return new ResponseEntity<>(new Message().builder()
                .status(StatusEnum.OK)
                .message("성공")
                .data(coupangDto.getData()).build(), headers, HttpStatus.OK);
    }
}
