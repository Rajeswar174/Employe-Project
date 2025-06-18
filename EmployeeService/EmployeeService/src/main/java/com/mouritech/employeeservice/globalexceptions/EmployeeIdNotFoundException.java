package com.mouritech.employeeservice.globalexceptions;

public class EmployeeIdNotFoundException extends RuntimeException {
	
	public EmployeeIdNotFoundException(String message) {
        super(message);
    }

}
