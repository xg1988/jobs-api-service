package com.api.jobsapiservice.api.ipo;

import com.api.jobsapiservice.dto.IPOInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPOInfoRepository extends JpaRepository<IPOInfoDto, String> {
    public List<IPOInfoDto> findByRegistDate(String odate);

    public Optional<IPOInfoDto> findById(String id);
}
