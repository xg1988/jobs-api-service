package com.api.jobsapiservice.api.publicdata.realestate;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.util.HttpConnection;
import com.api.jobsapiservice.util.JSONFromXMLService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


public interface RealEstateService {
    public RealEstateResultDto getRealEstateTransaction(String pageNo
            , String numOfRows
            , String lawdCd
            , String dealYmd);
}
