package com.api.jobsapiservice.api.coupang;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.util.HmacGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;

@Service
@Slf4j
public class CoupangService {

    @Value("${coupang.domain}")
    private String DOMAIN;

    @Value("${coupang.access_key}")
    private String ACCESS_KEY;

    @Value("${coupang.secret_key}")
    private String SECRET_KEY;

    private final static String REQUEST_JSON = "{\"coupangUrls\": [\"replacer\"]}";

    public CoupangDto bestcategories(String categoryId, int size) throws ParseException, IOException {
        String requestUrl = "/v2/providers/affiliate_open_api/apis/openapi/products/bestcategories/"+categoryId+"?limit="+size;

        // Generate HMAC string
        String authorization = HmacGenerator.generate(BaseConst.GET_REQUEST_METHOD, requestUrl, SECRET_KEY, ACCESS_KEY);

        org.apache.http.HttpHost host = org.apache.http.HttpHost.create(DOMAIN);
        org.apache.http.HttpRequest request = org.apache.http.client.methods.RequestBuilder
                //.post(URL).setEntity(entity)
                .get(requestUrl)
                .addHeader(BaseConst.AUTHORIZATION_HEADER_KEY, authorization)
                .build();

        org.apache.http.HttpResponse httpResponse = org.apache.http.impl.client.HttpClientBuilder.create().build().execute(host, request);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(EntityUtils.toString(httpResponse.getEntity()), CoupangDto.class);
    }

    public CoupangDto goldbox() throws ParseException, IOException {

        String requestUrl = "/v2/providers/affiliate_open_api/apis/openapi/products/goldbox";

        // Generate HMAC string
        String authorization = HmacGenerator.generate(BaseConst.GET_REQUEST_METHOD, requestUrl, SECRET_KEY, ACCESS_KEY);

        org.apache.http.HttpHost host = org.apache.http.HttpHost.create(DOMAIN);
        org.apache.http.HttpRequest request = org.apache.http.client.methods.RequestBuilder

                .get(requestUrl)
                .addHeader(BaseConst.AUTHORIZATION_HEADER_KEY, authorization)
                .build();
        org.apache.http.HttpResponse httpResponse = org.apache.http.impl.client.HttpClientBuilder.create().build().execute(host, request);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(EntityUtils.toString(httpResponse.getEntity()), CoupangDto.class);
    }
    public CoupangSearchDto search(String keyword, int size) throws ParseException, IOException {

        String requestUrl = "/v2/providers/affiliate_open_api/apis/openapi/products/search?keyword="+URLEncoder.encode(keyword)+"&limit="+size;

        // Generate HMAC string
        String authorization = HmacGenerator.generate(BaseConst.GET_REQUEST_METHOD, requestUrl, SECRET_KEY, ACCESS_KEY);

        org.apache.http.HttpHost host = org.apache.http.HttpHost.create(DOMAIN);
        org.apache.http.HttpRequest request = org.apache.http.client.methods.RequestBuilder

                .get(requestUrl)
                .addHeader(BaseConst.AUTHORIZATION_HEADER_KEY, authorization)
                .build();

        org.apache.http.HttpResponse httpResponse = org.apache.http.impl.client.HttpClientBuilder.create().build().execute(host, request);
        String httpResponseString = EntityUtils.toString(httpResponse.getEntity());
        log.info("httpResponseString : {}",httpResponseString);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(httpResponseString, CoupangSearchDto.class);
    }

    public CoupangLinkDto deeplink(String targetUrl) throws ParseException, IOException {

        String requestUrl = "/v2/providers/affiliate_open_api/apis/openapi/deeplink";

        // Generate HMAC string
        String authorization = HmacGenerator.generate(BaseConst.POST_REQUEST_METHOD, requestUrl, SECRET_KEY, ACCESS_KEY);

        StringEntity entity = new StringEntity(REQUEST_JSON.replaceAll("replacer", targetUrl), BaseConst.DEFAULT_CHAR_SET);
        entity.setContentEncoding(BaseConst.DEFAULT_CHAR_SET);
        entity.setContentType(BaseConst.APPLICATION_JSON_TYPE);

        org.apache.http.HttpHost host = org.apache.http.HttpHost.create(DOMAIN);
        org.apache.http.HttpRequest request = org.apache.http.client.methods.RequestBuilder
                .post(requestUrl).setEntity(entity)
                //.get(requestUrl)
                .addHeader(BaseConst.AUTHORIZATION_HEADER_KEY, authorization)
                .build();

        org.apache.http.HttpResponse httpResponse = org.apache.http.impl.client.HttpClientBuilder.create().build().execute(host, request);
        String httpResponseString = EntityUtils.toString(httpResponse.getEntity());
        log.info("httpResponseString : {}",httpResponseString);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(httpResponseString, CoupangLinkDto.class);
    }
}
