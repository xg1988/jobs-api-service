package com.api.jobsapiservice.api.publicdata.realestate;

import com.api.jobsapiservice.api.publicdata.HeaderDto;
import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.util.HttpConnection;
import com.api.jobsapiservice.util.JSONFromXMLService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@Slf4j
public class RealEstateServiceImpl implements RealEstateService{
    @Value("${common.realestate.url}")
    private String URL;

    @Value("${common.realestate.service_key}")
    private String SERVICE_KEY;

    private HttpConnection httpConnection;
    private JSONFromXMLService jsonFromXMLService;
    public RealEstateServiceImpl(HttpConnection httpConnection
                            , JSONFromXMLService jsonFromXMLService){
        this.httpConnection = httpConnection;
        this.jsonFromXMLService = jsonFromXMLService;
    }

    public RealEstateResultDto getRealEstateTransaction(String pageNo
                                                        , String numOfRows
                                                        , String lawdCd
                                                        , String dealYmd                             ) {
        RealEstateResultDto realEstateResultDto = null;

        try {
            RealEstateRequestDto realEstateRequestDto = RealEstateRequestDto.builder()
                    .dealYmd(dealYmd)
                    .lawdCd(lawdCd)
                    .numOfRows(numOfRows)
                    .pageNo(pageNo)
                    .serviceKey(SERVICE_KEY)
                    .build();
            String reqUrl = URL+ realEstateRequestDto.getQueryString();
            String result = httpConnection.call(reqUrl, BaseConst.GET_REQUEST_METHOD);

            JSONObject jsonObject = jsonFromXMLService.getJSONObjecFromXML(result);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            realEstateResultDto = objectMapper.readValue(jsonObject.getJSONObject("response").toString(), RealEstateResultDto.class);
        }catch (UnsupportedEncodingException e){
            log.error("error : {}", e.getMessage());
        }catch (JsonMappingException e){
            log.error("error : {}", e.getMessage());
        }catch (Exception e){
            log.error("error : {}", e.getMessage());
        }


        return realEstateResultDto;
    }
}
