package com.mouritech.projectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.projectservice.dto.ProjectDto;
import com.mouritech.projectservice.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/getAllProjects")
	public ResponseEntity<List<ProjectDto>> getAllProjects() {
		System.out.println("Fetching employees from DB...");
		List<ProjectDto> projectDtos = projectService.getAllProjects();
		if (projectDtos != null && !projectDtos.isEmpty()) {
			return ResponseEntity.ok(projectDtos);
		} else {
			return ResponseEntity.noContent().build();
		}

	}

	@PostMapping("/createProject")
	public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto dto) {
		return new ResponseEntity<>(projectService.createProject(dto), HttpStatus.CREATED);
	}

	@PutMapping("updateProject/{id}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto dto) {
		return ResponseEntity.ok(projectService.updateProject(id, dto));
	}
}
