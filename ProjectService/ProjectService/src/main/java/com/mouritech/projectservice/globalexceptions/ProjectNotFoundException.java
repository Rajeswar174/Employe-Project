package com.mouritech.projectservice.globalexceptions;

public class ProjectNotFoundException extends RuntimeException {
	
	public ProjectNotFoundException(String message) {
        super(message);
    }

}
