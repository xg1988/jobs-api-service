package com.api.jobsapiservice.api.publicdata;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class HeaderDto {

    private String resultCode;
    private String resultMsg;
}
