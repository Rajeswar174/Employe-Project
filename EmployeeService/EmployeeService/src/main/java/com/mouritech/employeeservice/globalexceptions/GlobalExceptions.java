package com.mouritech.employeeservice.globalexceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptions {
	

    @ExceptionHandler(EmployeeIdNotFoundException.class)
    public ResponseEntity<?> handleEmployeeIdNotFound(EmployeeIdNotFoundException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("error", "Employee Not Found");
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String,String>> handleConstraintViolationException(ConstraintViolationException e)
	{
		Set<ConstraintViolation<?>> c=e.getConstraintViolations();
		Map<String,String> mapResults=new HashMap<>();
		for(ConstraintViolation<?> e1:c)
		{
			String s1=e1.getPropertyPath().toString();
			String s2=e1.getMessage();
			mapResults.put(s1, s2);
		}
		return new ResponseEntity<Map<String,String>>(mapResults,HttpStatus.BAD_REQUEST);
		
	}
	

}
