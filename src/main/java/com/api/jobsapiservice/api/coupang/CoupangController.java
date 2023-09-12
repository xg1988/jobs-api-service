package com.api.jobsapiservice.api.coupang;

import com.api.jobsapiservice.contants.BaseConst;
import com.api.jobsapiservice.dto.Message;
import com.api.jobsapiservice.dto.StatusEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
@RequestMapping(value = "/coupang")
public class CoupangController {

    private final CoupangService coupangService;

    public CoupangController(CoupangService coupangService) {
        this.coupangService = coupangService;
    }

    @GetMapping(value = "bestcategories/{categoryId}")
    public ResponseEntity bestcategories(@PathVariable String categoryId){
        return null;
    }
}
