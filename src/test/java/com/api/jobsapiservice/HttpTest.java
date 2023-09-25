package com.api.jobsapiservice;

import com.api.jobsapiservice.api.coupang.CoupangDto;
import com.api.jobsapiservice.api.publicdata.realestate.RealEstateRequestDto;
import com.api.jobsapiservice.api.publicdata.realestate.RealEstateResultDto;
import com.api.jobsapiservice.api.publicdata.realestate.RealEstateService;
import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.util.HttpConnection;
import com.api.jobsapiservice.util.JSONFromXMLService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;


import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@PropertySource("classpath:application-local.yml")
public class HttpTest {

    @Autowired
    HttpConnection httpConnection;

    @Autowired
    JSONFromXMLService jsonFromXMLService;

    @Autowired
    RealEstateService realEstateService;

    @DisplayName("1. get 테스트")
    @Test
    void test_1(){
        String result = httpConnection.call("https://naver.com", "GET");

        System.out.println("시스템로그 [result]: " + result);

        //assertThat(coupangDto.getrCode()).isEqualTo("0");
        assertThat(result).isNotEmpty();
    }


    @DisplayName("2. get 테스트")
    @Test
    void test_2() throws UnsupportedEncodingException, JsonProcessingException {
        String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
        RealEstateRequestDto realEstateRequestDto = RealEstateRequestDto.builder()
                .dealYmd("202309")
                .lawdCd("11530")
                .numOfRows("10")
                .pageNo("1")
                .serviceKey("서비스키").build();
        String reqUrl = url+ realEstateRequestDto.getQueryString();
//        System.out.println("시스템로그 []: " + reqUrl);

        String result = httpConnection.call(reqUrl, BaseConst.GET_REQUEST_METHOD);
//        System.out.println("시스템로그 [result]: " + result);

        JSONObject jsonObject = jsonFromXMLService.getJSONObjecFromXML(result);
//        System.out.println("시스템로그 [jsonObject.toString()]: " + jsonObject.toString());
        String test = jsonObject.getJSONObject("response").getJSONObject("body").toString();
//        System.out.println("시스템로그 [test]: " + test);
        String test2 = jsonObject.getJSONObject("response").getJSONObject("body").getJSONObject("items").toString();
//        System.out.println("시스템로그 [test2]: " + test2);

        JSONArray jsonArray = jsonObject.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RealEstateResultDto realEstateResultDto = objectMapper.readValue(jsonObject.getJSONObject("response").toString(), RealEstateResultDto.class);

        System.out.println("시스템로그 []: " + realEstateResultDto.toString());

        assertThat(result).isNotEmpty();
    }


    @DisplayName("3. 서비스 테스트")
    @Test
    void test_3() throws UnsupportedEncodingException, JsonProcessingException {
        RealEstateResultDto realEstateResultDto = realEstateService.getRealEstateTransaction("1", "20", "202309", "11110");
        System.out.println("시스템로그 []: " + realEstateResultDto.toString());
    }
}
