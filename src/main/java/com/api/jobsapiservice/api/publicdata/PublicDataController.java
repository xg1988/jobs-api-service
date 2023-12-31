package com.api.jobsapiservice.api.publicdata;

import com.api.jobsapiservice.api.publicdata.realestate.RealEstateResultDto;
import com.api.jobsapiservice.api.publicdata.realestate.RealEstateService;
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

@RestController
@RequestMapping(value = "/public")
public class PublicDataController {

    private RealEstateService realEstateService;

    public PublicDataController(RealEstateService realEstateService){
        this.realEstateService = realEstateService;
    }

    /**
     * 부동산 실거래가 조회 (아파트)
     * @param pageNo
     * @param numOfRows
     * @param lawdCd
     * @param dealYmd
     * @return
     */
    @GetMapping(value = "/realestate/{pageNo}/{numOfRows}/{lawdCd}/{dealYmd}")
    public ResponseEntity getRealestate(@PathVariable String pageNo
                                        , @PathVariable String numOfRows
                                        , @PathVariable String lawdCd
                                        , @PathVariable String dealYmd){

        /**
         * 부동산 정보 호출
         */
        RealEstateResultDto realEstateResultDto = realEstateService.getRealEstateTransaction(
                                                                    pageNo
                                                                    , numOfRows
                                                                    , lawdCd
                                                                    , dealYmd);

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType(BaseConst.DEFAULT_CONTENT_TYPE
                , BaseConst.DEFAULT_SUB_TUPE
                , Charset.forName(BaseConst.DEFAULT_CHAR_SET)));

        return new ResponseEntity<>(new Message().builder()
                .status(StatusEnum.OK)
                .message("성공")
                .data(realEstateResultDto.getBody()).build(), headers, HttpStatus.OK);
    }
}
