package com.api.jobsapiservice.api.publicdata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RealEstateRequestDto {
    private String pageNo;
    private String numOfRows;
    private String lawdCd;
    private String dealYmd;
    private String serviceKey;

    public String getQueryString(){
        return "?serviceKey=" + this.serviceKey + "&numOfRows=" + this.numOfRows
                + "&lawdCd=" + this.lawdCd + "&dealYmd=" + this.dealYmd
                + "&pageNo=" + this.pageNo;
    }
}
