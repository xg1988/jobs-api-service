package com.api.jobsapiservice.api.coupang;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class CoupangDto {
    private String rCode;
    private String rMessage;
    private List<DataDto> data;

    public String getrCode(){
        return this.rCode;
    }

    public String getrMessage(){
        return this.rMessage;
    }

    @Data
    static class DataDto{
        private String productId;
        private String productName;
        private String productPrice;
        private String productImage;
        private String productUrl;
        private String categoryName;
        private String keyword;
        private String rank;
        private boolean isRocket;
        private boolean isFreeShipping;
    }
}
