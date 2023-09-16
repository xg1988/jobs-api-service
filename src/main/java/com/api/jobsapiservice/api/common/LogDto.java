package com.api.jobsapiservice.api.common;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Table(name="common_log")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LogDto {

    @Id
    private String guid;
    private String method;
    private String userId;
    private String data;
    private String localIp;
    private String registDate;
}
