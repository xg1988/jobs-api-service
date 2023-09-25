package com.api.jobsapiservice.api.publicdata.realestate;

import com.api.jobsapiservice.api.publicdata.HeaderDto;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class RealEstateResultDto {

    HeaderDto header;
    BodyDto body;

    @Data
    static class BodyDto{
        private String pageNo;
        private String totalCount;

        ItemsDto items;

        @Data
        static class ItemsDto{
            List<ItemDto> item;

            @Data
            static class ItemDto{
                private String 도로명건물부번호코드;
                private String 법정동지번코드;
                private String 지역코드;
                private String 도로명시군구코드;
                private String 도로명일련번호코드;
                private String 아파트;
                private String 도로명지상지하코드;
                private String 지번;
                private String 도로명;
                private String 등기일자;
                private String 월;
                private String 법정동읍면동코드;
                private String 법정동시군구코드;
                private String 건축년도;
                private String 전용면적;
                private String 해제사유발생일;

                private String 일련번호;
                private String 거래금액;
                private String 도로명코드;
                private String 법정동본번코드;
                private String 중개사소재지;
                private String 법정동부번코드;
                private String 거래유형;
                private String 해제여부;
                private String 층;
                private String 일;
                private String 도로명건물본번호코드;
            }
        }
    }
}
