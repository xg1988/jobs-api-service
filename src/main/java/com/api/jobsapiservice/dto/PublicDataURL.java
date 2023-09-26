package com.api.jobsapiservice.dto;

public enum PublicDataURL {
    REAL_ESTATE_URL ("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev");

    private final String url;

    private PublicDataURL(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }
}
