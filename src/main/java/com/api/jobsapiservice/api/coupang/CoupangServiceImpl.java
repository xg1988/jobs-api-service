package com.api.jobsapiservice.api.coupang;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.util.HmacGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

@Service
@Slf4j
public class CoupangServiceImpl implements CoupangService{

    @Value("${coupang.domain}")
    private String DOMAIN;

    @Value("${coupang.access_key}")
    private String ACCESS_KEY;

    @Value("${coupang.secret_key}")
    private String SECRET_KEY;

    private final static String REQUEST_JSON = "{\"coupangUrls\": [\"replacer\"]}";

    public String _callAPICoupang(String requestUrl) throws IOException {
        // Generate HMAC string
        String authorization = HmacGenerator.generate(BaseConst.GET_REQUEST_METHOD
                                                    , requestUrl
                                                    , SECRET_KEY
                                                    , ACCESS_KEY);

        org.apache.http.HttpHost host = org.apache.http.HttpHost.create(DOMAIN);
        org.apache.http.HttpRequest request = org.apache.http.client.methods.RequestBuilder
                //.post(URL).setEntity(entity)
                .get(requestUrl)
                .addHeader(BaseConst.AUTHORIZATION_HEADER_KEY, authorization)
                .build();

        org.apache.http.HttpResponse httpResponse = org.apache.http.impl.client.HttpClientBuilder.create().build().execute(host, request);

        return EntityUtils.toString(httpResponse.getEntity());
    }


    public CoupangDto bestcategories(String categoryId, int size) throws ParseException, IOException {
        String requestUrl = "/v2/providers/affiliate_open_api/apis/openapi/products/bestcategories/"+categoryId+"?limit="+size;

        String httpResponse = _callAPICoupang(requestUrl);
        log.debug("httpResponse => {}", httpResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(httpResponse, CoupangDto.class);
    }

    public CoupangDto goldbox() throws ParseException, IOException {

        String requestUrl = "/v2/providers/affiliate_open_api/apis/openapi/products/goldbox";

        String httpResponse = _callAPICoupang(requestUrl);
        log.debug("httpResponse => {}", httpResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(httpResponse, CoupangDto.class);
    }
    public CoupangSearchDto search(String keyword, int size) throws ParseException, IOException {

        String requestUrl = "/v2/providers/affiliate_open_api/apis/openapi/products/search?keyword="+URLEncoder.encode(keyword)+"&limit="+size;

        String httpResponse = _callAPICoupang(requestUrl);
        log.debug("httpResponse => {}", httpResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(httpResponse, CoupangSearchDto.class);
    }
}
