package com.api.jobsapiservice;

import com.api.jobsapiservice.api.coupang.CoupangDto;
import com.api.jobsapiservice.api.coupang.CoupangLinkDto;
import com.api.jobsapiservice.api.coupang.CoupangSearchDto;
import com.api.jobsapiservice.api.coupang.CoupangService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@PropertySource("classpath:application-local.yml")
public class CoupangAPITest {

    @Autowired
    CoupangService coupangService;

    @DisplayName("1. 쿠팡 기본 테스트")
    @Test
    void test_1() throws IOException {
        CoupangDto coupangDto =  coupangService.goldbox();
        assertThat(coupangDto.getrCode()).isEqualTo("0");
    }


    @DisplayName("2. 검색 테스트")
    @Test
    void test_2() throws IOException {
        CoupangSearchDto coupangSearchDto = coupangService.search("갤럭시", 10);
        assertThat(coupangSearchDto.getrCode()).isEqualTo("0");
    }


    @DisplayName("3. 베스트 카테고리")
    @Test
    void test_3() throws IOException {
        CoupangDto coupangDto = coupangService.bestcategories("1001", 10);
        assertThat(coupangDto.getrCode()).isEqualTo("0");
    }


    @DisplayName("4. 주소")
    @Test
    void test_4() throws IOException {
        CoupangLinkDto coupangLinkDto = coupangService.deeplink("https://www.coupang.com/vp/products/184614775");
        assertThat(coupangLinkDto.getrCode()).isEqualTo("0");
    }
}
