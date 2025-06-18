package com.mouritech.projectservice.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.projectservice.dao.ProjectRepository;
import com.mouritech.projectservice.dto.ProjectDto;
import com.mouritech.projectservice.entity.Project;
import com.mouritech.projectservice.globalexceptions.ProjectNotFoundException;
import com.mouritech.projectservice.service.ProjectService;

@Service
public class ProjectServieImpl implements ProjectService{
	
	@Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;
    

	@Override
	public ProjectDto createProject(ProjectDto dto) {
		Project project = modelMapper.map(dto, Project.class);
        return modelMapper.map(projectRepository.save(project), ProjectDto.class);
	}

	@Override
	public List<ProjectDto> getAllProjects() {
		return projectRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProjectDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public ProjectDto updateProject(Long id, ProjectDto dto) {
		 Project project = projectRepository.findById(id)
	                .orElseThrow(() -> new ProjectNotFoundException("Project not found"));
	        project.setProjectName(dto.getProjectName());
	        project.setClient(dto.getClient());
	        project.setStatus(dto.getStatus());
	        project.setDeadline(dto.getDeadline());
	        return modelMapper.map(projectRepository.save(project), ProjectDto.class);
	}

}
