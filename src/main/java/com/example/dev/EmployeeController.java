package com.example.dev;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@RestController
public class EmployeeController {
	
	@JsonPropertyOrder
	@PutMapping(path="/empUpdate",produces=MediaType.APPLICATION_JSON,consumes=MediaType.APPLICATION_JSON)
	public ResponseEntity<Employee> employeeDetails(@RequestBody Employee emp) {
		return ResponseEntity.status(HttpStatus.OK).body(emp);
		
	}

}
