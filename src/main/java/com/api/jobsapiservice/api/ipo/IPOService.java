package com.api.jobsapiservice.api.ipo;

import java.util.List;
import java.util.Optional;

public interface IPOService {
    public List<IPOInfoDto> getIPOInfoList(String odate);
    public Optional<IPOInfoDto> getIPOInfoDetail(String id);
    public Optional<IPOInfoDto> getIPOInfoDetailString(String id);
}
