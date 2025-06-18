package com.mouritech.employeeservice.service;

import com.mouritech.employeeservice.dto.EmployeeDto;
import java.util.List;


public interface EmpoyeeService {
	
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public EmployeeDto getEmployeeById(Long employeeId);
	public List<EmployeeDto> getAllEmployees();
	public String deleteEmployeeById(Long employeeId);
	
	

}
