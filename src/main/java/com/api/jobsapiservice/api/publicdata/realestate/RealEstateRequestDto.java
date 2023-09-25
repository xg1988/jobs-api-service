package com.api.jobsapiservice.api.publicdata.realestate;

import com.api.jobsapiservice.contants.BaseConst;
import lombok.Builder;
import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@Builder
public class RealEstateRequestDto {
    private String pageNo;
    private String numOfRows;
    private String lawdCd;
    private String dealYmd;
    private String serviceKey;

    public String getQueryString() throws UnsupportedEncodingException {
        return "?serviceKey=" + URLEncoder.encode(this.serviceKey, BaseConst.DEFAULT_CHAR_SET)
                + "&numOfRows=" + URLEncoder.encode(this.numOfRows, BaseConst.DEFAULT_CHAR_SET)
                + "&LAWD_CD=" + URLEncoder.encode(this.lawdCd, BaseConst.DEFAULT_CHAR_SET)
                + "&DEAL_YMD=" + URLEncoder.encode(this.dealYmd, BaseConst.DEFAULT_CHAR_SET)
                + "&pageNo=" + URLEncoder.encode(this.pageNo, BaseConst.DEFAULT_CHAR_SET) ;
    }
}
