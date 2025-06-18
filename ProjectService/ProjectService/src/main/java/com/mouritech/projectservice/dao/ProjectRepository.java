package com.mouritech.projectservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.projectservice.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	
	
	

}
