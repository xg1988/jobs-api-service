package com.api.jobsapiservice.api.common;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogDto, String> {
}
