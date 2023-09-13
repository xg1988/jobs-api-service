package com.api.jobsapiservice.api.coupang;

import lombok.Data;

import java.util.List;

@Data
public class CoupangLinkDto {

    private String rCode;
    private String rMessage;
    public String getrCode(){
        return this.rCode;
    }
    public String getrMessage(){
        return this.rMessage;
    }

    @Data
    static class CoupangLink{
        private String landingUrl;
        private String shortenUrl;
        private String originalUrl;
    }
}

