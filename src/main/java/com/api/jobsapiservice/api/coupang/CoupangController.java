package com.api.jobsapiservice.api.coupang;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.dto.Message;
import com.api.jobsapiservice.dto.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.Charset;

@RestController
@RequestMapping(value = "/coupang")
@Slf4j
public class CoupangController {

    private final CoupangService coupangService;

    public CoupangController(CoupangService coupangService) {
        this.coupangService = coupangService;
    }

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
