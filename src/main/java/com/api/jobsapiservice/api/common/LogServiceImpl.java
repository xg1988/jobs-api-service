package com.api.jobsapiservice.api.common;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{

    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public int insertLog(LogDto logDto) {

        logRepository.save(logDto);
        return 0;
    }
}
