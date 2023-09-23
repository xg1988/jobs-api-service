package com.api.jobsapiservice;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.util.HttpConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@PropertySource("classpath:application-local.yml")
public class HttpTest {

    @Autowired
    HttpConnection httpConnection;

    @DisplayName("1. get 테스트")
    @Test
    void test_1(){
        String result = httpConnection.call("https://naver.com", "GET");

        System.out.println("시스템로그 [result]: " + result);

        //assertThat(coupangDto.getrCode()).isEqualTo("0");
        assertThat(result).isNotEmpty();
    }


}
