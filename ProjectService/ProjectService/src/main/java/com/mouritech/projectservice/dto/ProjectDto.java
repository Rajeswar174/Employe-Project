package com.mouritech.projectservice.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

	private Long id;
	private String projectName;
	private String client;
	private String status;
	private Date deadline;

}
