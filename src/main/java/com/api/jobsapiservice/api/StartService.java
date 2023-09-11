package com.api.jobsapiservice.api;

import com.api.jobsapiservice.dto.IPOInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StartService {

    private final StartRepository startRepository;
    StartService(StartRepository startRepository){
        this.startRepository = startRepository;
    }

    public List<IPOInfoDto> getIPOInfoList(String odate){
        List<IPOInfoDto> list = startRepository.findByRegistDate(odate);
        list.forEach(infoDto->{
            log.info("infoDto : {}", infoDto);
        });
        return list;
    }
}
