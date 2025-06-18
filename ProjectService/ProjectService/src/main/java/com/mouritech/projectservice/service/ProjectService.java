package com.mouritech.projectservice.service;

import java.util.List;

import com.mouritech.projectservice.dto.ProjectDto;

public interface ProjectService {
	
	public ProjectDto createProject(ProjectDto dto);
	public List<ProjectDto> getAllProjects() ;
    public ProjectDto updateProject(Long id, ProjectDto dto);

}
