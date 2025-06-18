package com.mouritech.employeeservice.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.employeeservice.dto.EmployeeDto;
import com.mouritech.employeeservice.entity.EmployeeEntity;
import com.mouritech.employeeservice.globalexceptions.EmployeeIdNotFoundException;
import com.mouritech.employeeservice.repository.EmpyoyeeDAO;
import com.mouritech.employeeservice.service.EmpoyeeService;


@Service
public class EmployeeServiceImpl  implements EmpoyeeService {
	
	
	@Autowired
	private EmpyoyeeDAO empyoyeeDAO;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// Convert DTO to Entity
		EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
		// Save the entity to the database
		EmployeeEntity savedEntity = empyoyeeDAO.save(employeeEntity);
		// Convert saved entity back to DTO	
		return modelMapper.map(savedEntity, EmployeeDto.class);		
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// Find the employee by ID	
		EmployeeEntity employeeEntity = empyoyeeDAO.findById(employeeId)
			    .orElseThrow(() -> new EmployeeIdNotFoundException("Employee ID not found with id: " + employeeId));
        // Convert entity to DTO
		
		return modelMapper.map(employeeEntity, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// Fetch all employees from the database
		List<EmployeeEntity> employeeEntities = empyoyeeDAO.findAll();
		// Convert list of entities to list of DTOs
		  return employeeEntities.stream()
				.map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class)).toList();
	}

	@Override
	public String deleteEmployeeById(Long employeeId) {
	    // Check if employee exists
		if (empyoyeeDAO.existsById(employeeId)) {
			// Delete the employee by ID
			empyoyeeDAO.deleteById(employeeId);
			return "Employee with ID " + employeeId + " deleted successfully.";
		} else 
			throw new EmployeeIdNotFoundException("Employee ID not found with id: " + employeeId);
	}

	
	
}
