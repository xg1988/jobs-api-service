package com.api.jobsapiservice.api.ipo;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.dto.Message;
import com.api.jobsapiservice.dto.StatusEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

@RequestMapping("/ipoinfo")
@RestController
public class IPOInfoController {

    private final IPOInfoServiceImpl ipoInfoService;

    public IPOInfoController(IPOInfoServiceImpl ipoInfoService) {
        this.ipoInfoService = ipoInfoService;
    }


    /**
     * 공모주 정보 기준일자별 목록 출력
     * @param odate
     * @return
     */
    @GetMapping(value = "/ipos/{odate}")
    public ResponseEntity ipos(@PathVariable String odate){

        List<IPOInfoDto> list = ipoInfoService.getIPOInfoList(odate);

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType(BaseConst.DEFAULT_CONTENT_TYPE
                , BaseConst.DEFAULT_SUB_TUPE
                , Charset.forName(BaseConst.DEFAULT_CHAR_SET)));

        return new ResponseEntity<>(new Message().builder()
                .status(StatusEnum.OK)
                .message("성공")
                .data(list).build(), headers, HttpStatus.OK);
    }

    /**
     * 공모주 정보 단건 출력
     * @param id
     * @return
     */
    @GetMapping(value = "/ipo/{id}")
    public ResponseEntity ipo(@PathVariable String id){

        Optional<IPOInfoDto> ipoInfoDto = ipoInfoService.getIPOInfoDetail(id);

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType(BaseConst.DEFAULT_CONTENT_TYPE
                , BaseConst.DEFAULT_SUB_TUPE
                , Charset.forName(BaseConst.DEFAULT_CHAR_SET)));

        return new ResponseEntity<>(new Message().builder()
                .status(StatusEnum.OK)
                .message("성공")
                .data(ipoInfoDto).build(), headers, HttpStatus.OK);
    }

    /**
     * 블로그 포스팅에 맞는 문자열로 응답
     * @param id
     * @return
     */
    @GetMapping(value = "/ipo-post/{id}")
    public ResponseEntity ipoPost(@PathVariable String id){

        Optional<IPOInfoDto> ipoInfoDto = ipoInfoService.getIPOInfoDetail(id);

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType(BaseConst.DEFAULT_CONTENT_TYPE
                , BaseConst.DEFAULT_SUB_TUPE
                , Charset.forName(BaseConst.DEFAULT_CHAR_SET)));

        return new ResponseEntity<>(new Message().builder()
                .status(StatusEnum.OK)
                .message("성공")
                .data(ipoInfoDto).build(), headers, HttpStatus.OK);
    }
}
