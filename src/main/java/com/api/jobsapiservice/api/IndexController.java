package com.api.jobsapiservice.api;

import com.api.jobsapiservice.dto.Message;
import com.api.jobsapiservice.dto.StatusEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "index.html";
    }
}
