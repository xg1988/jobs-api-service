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
        String url = "jdbc:mysql://localhost:3306/jobsservice";
        String username = "jobs01";
        String password = "l2p7w4!!";
        System.out.println("url: ENC(" + jasyptConfig.stringEncryptor().encrypt(url) + ")");
        System.out.println("username: ENC(" + jasyptConfig.stringEncryptor().encrypt(username)+ ")");
        System.out.println("password: ENC(" + jasyptConfig.stringEncryptor().encrypt(password)+ ")");
/**
 *     url: ENC(VcHnFPAZ8a1zkFp4OqB0BwAoGVtA4ZnWt5cvczww7PUFmINk+t+fXLZN3rkPTjFeeIFDA17W6QA=)
 *     username: ENC(WJcwD1Qi8atm1ezWhpqHDA==)
 *     password: ENC(80YPILKsH1/tueRSiwvp3wJ7H4GOl05O)
 */
        String encUrl = "VcHnFPAZ8a1zkFp4OqB0BwAoGVtA4ZnWt5cvczww7PUFmINk+t+fXLZN3rkPTjFeeIFDA17W6QA=";
        String encUsername = "WJcwD1Qi8atm1ezWhpqHDA==";
        String encPassword = "80YPILKsH1/tueRSiwvp3wJ7H4GOl05O";
        System.out.println("url: ENC(" + jasyptConfig.stringEncryptor().decrypt(encUrl) + ")");
        System.out.println("username: ENC(" + jasyptConfig.stringEncryptor().decrypt(encUsername)+ ")");
        System.out.println("password: ENC(" + jasyptConfig.stringEncryptor().decrypt(encPassword)+ ")");
    }
}
