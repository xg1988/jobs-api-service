package com.api.jobsapiservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTest {



    @DisplayName("1. ")
    @Test
    void test_1(){
        System.out.println("시스템로그 []: "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMDDHHMMSS")));
        System.out.println("시스템로그 []: "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmm")));
    }
}
