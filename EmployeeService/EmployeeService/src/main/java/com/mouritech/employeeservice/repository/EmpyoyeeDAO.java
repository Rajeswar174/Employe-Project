package com.mouritech.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.employeeservice.entity.EmployeeEntity;

@Repository
public interface EmpyoyeeDAO extends JpaRepository<EmployeeEntity, Long> {
}
