package com.api.jobsapiservice;

import com.api.jobsapiservice.api.coupang.CoupangService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

@SpringBootTest
@PropertySource("classpath:application-local.yml")
public class CoupangAPITest {

    @Autowired
    CoupangService coupangService;

    @DisplayName("1. 쿠팡 기본 테스트")
    @Test
    void test_1() throws IOException {
        coupangService.goldbox();
    }


    @DisplayName("2. 검색 테스트")
    @Test
    void test_2() throws IOException {
        coupangService.search("갤럭시", 10);
    }


    @DisplayName("3. 베스트 카테고리")
    @Test
    void test_3() throws IOException {
        coupangService.bestcategory("1001", 10);
    }
}
