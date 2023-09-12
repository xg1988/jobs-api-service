package com.api.jobsapiservice.api;

import com.api.jobsapiservice.dto.StatusEnum;
import com.api.jobsapiservice.dto.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/start")
@RestController
public class StartController {
    private final StartService startService;

    public StartController(StartService startService) {
        this.startService = startService;
    }

    /**
     * 기본 응답 세팅
     * @return
     */
    @RequestMapping(value = "/base-response")
    public ResponseEntity index(){
        //return new ResponseEntity(HttpStatus.OK);
        Map<String, Object> map = new HashMap<>();
        map.put("id", "test");
        //List<IPOInfoDto> list = startService.getIPOInfoList("20230910");

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application"
                                            , "json"
                                            , Charset.forName("UTF-8")));

        return new ResponseEntity<>(new Message().builder()
                                        .status(StatusEnum.OK)
                                        .message("성공")
                                        .data(map).build(), headers, HttpStatus.OK);
    }
}
