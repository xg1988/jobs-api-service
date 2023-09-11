package com.api.jobsapiservice.api;

import com.api.jobsapiservice.dto.IPOInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StartRepository extends JpaRepository<IPOInfoDto, String> {
    public List<IPOInfoDto> findByRegistDate(String odate);
}
