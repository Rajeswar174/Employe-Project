package com.mouritech.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.employeeservice.dto.EmployeeDto;
import com.mouritech.employeeservice.service.EmpoyeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmpoyeeService empoyeeService;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> postEmpoyeeDto(@Valid  @RequestBody EmployeeDto employeeDto) {
		EmployeeDto createdEmployee = empoyeeService.createEmployee(employeeDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
	}
	@GetMapping("/get/{employeeId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
		EmployeeDto employeeDto = empoyeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
	    System.out.println("Fetching employees from DB...");
        List<EmployeeDto> employeeDtos = empoyeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtos);	
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId) {
		String responseMessage = empoyeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.ok(responseMessage);
	}

}
