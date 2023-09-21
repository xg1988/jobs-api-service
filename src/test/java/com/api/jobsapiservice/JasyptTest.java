package com.api.jobsapiservice;

import com.api.jobsapiservice.util.JasyptConfig;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {
    @Autowired
    private JasyptConfig jasyptConfig;

    @DisplayName("1. 암/복호화 테스트")
    @Test
    void test_1(){
        String url = "주소";
        String username = "계정";
        String password = "비밀번호";
        System.out.println("url: ENC(" + jasyptConfig.stringEncryptor().encrypt(url) + ")");
        System.out.println("username: ENC(" + jasyptConfig.stringEncryptor().encrypt(username)+ ")");
        System.out.println("password: ENC(" + jasyptConfig.stringEncryptor().encrypt(password)+ ")");
    }
}
