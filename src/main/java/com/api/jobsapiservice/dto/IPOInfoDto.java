package com.api.jobsapiservice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDateTime;

@ToString
@Entity
@Table(name="naver_ipo_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IPOInfoDto {
	@Id
	public String id;
	public String compName;
	public String marketName;
	public String gongmoPrice;
	public String compCategory;
	public String gongmoComp;
	public String competition;
	public String requestTerm;
	public String listingDate;
	public String gongmoState;
	public String registDate;
	public LocalDateTime registTime;
}
