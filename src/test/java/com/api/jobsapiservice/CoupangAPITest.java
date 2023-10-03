package com.api.jobsapiservice;

import com.api.jobsapiservice.api.coupang.CoupangDto;
import com.api.jobsapiservice.api.coupang.CoupangSearchDto;
import com.api.jobsapiservice.api.coupang.CoupangServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

@SpringBootTest
@PropertySource("classpath:application-local.yml")
@AutoConfigureMockMvc
public class CoupangAPITest {

    @Autowired
    CoupangServiceImpl coupangService;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void mockMvcSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

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

/*
    @DisplayName("4. http call test")
    @Test
    void test_4(){
        //given
        final String keyword = "스마트폰";
        final int size = 10;
        final String url = "/coupang/goldbox";
        //when
        final ResultActions  resultActions = mockMvc.perform()

    }*/

}
