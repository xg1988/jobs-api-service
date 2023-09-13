package com.api.jobsapiservice.api.coupang;

import lombok.Data;

import java.util.List;

@Data
public class CoupangSearchDto {
    private String rCode;
    private String rMessage;
    private SearchDataDto data;

    public String getrCode(){
        return this.rCode;
    }

    public String getrMessage(){
        return this.rMessage;
    }

    @Data
    static class SearchDataDto{
        private String landingUrl;
        private List<DataDto> productData;
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
