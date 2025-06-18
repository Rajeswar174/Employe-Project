package com.mouritech.employeeservice.entity;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, message = "First name should have at least 2 characters")
	private String firstName;
	@Size(min = 2, message = "last name should have at least 2 characters")
	private String lastName;
	@Email(message = "Email should be valid")
	private String email;
	@Size(min = 10, message = "Phone number should have at least 10 characters")
	private String phoneNumber;
	@UpdateTimestamp
	private Date hireDate;
	@Size(min = 2, message = "designation name should have at least 2 characters")
	private String designation;
	@Size(min = 2, message = "department name should have at least 2 characters")
	private String department;
	

}
