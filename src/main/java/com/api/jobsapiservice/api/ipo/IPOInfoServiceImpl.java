package com.api.jobsapiservice.api.ipo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class IPOInfoServiceImpl implements IPOService{

    private final IPOInfoRepository ipoInfoRepository;

    public IPOInfoServiceImpl(IPOInfoRepository ipoInfoRepository) {
        this.ipoInfoRepository = ipoInfoRepository;
    }


    public List<IPOInfoDto> getIPOInfoList(String odate){
        List<IPOInfoDto> list = ipoInfoRepository.findByRegistDate(odate);
        list.forEach(infoDto->{
            log.info("infoDto : {}", infoDto);
        });
        return list;
    }

    public Optional<IPOInfoDto> getIPOInfoDetail(String id){
        Optional<IPOInfoDto> ipoInfo = ipoInfoRepository.findById(id);

        return ipoInfo;
    }

    public Optional<IPOInfoDto> getIPOInfoDetailString(String id){
        Optional<IPOInfoDto> ipoInfo = ipoInfoRepository.findById(id);
        return ipoInfo;
    }
}
