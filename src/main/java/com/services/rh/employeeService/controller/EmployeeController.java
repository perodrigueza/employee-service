package com.services.rh.employeeService.controller;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.rh.employeeService.model.dto.EmployeeRequest;
import com.services.rh.employeeService.model.dto.EmployeeResponse;
import com.services.rh.employeeService.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	private final EmployeeService employeeService;
	
	@GetMapping
	public List<EmployeeResponse> findAll(){
		logger.info("Get method");
		return employeeService.findAll();
	}
	
	@GetMapping("/{id}")
	public EmployeeResponse findById(@PathVariable Long id) {
		logger.info("Get method finById id=" + id);
		return employeeService.findById(id);
	}
	
	@GetMapping("/address/{addressId}")
	public EmployeeResponse findByAddressId(@PathVariable Long id) {
		logger.info("Get method finByAddressId addres id=" + id);
		return employeeService.findByAddressId(id);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> save(@Valid @RequestBody EmployeeRequest request) {
		EmployeeResponse response = employeeService.save(request);
		logger.info("Post method save");
		return ResponseEntity
				.created(URI.create("/api/employees/" + response.getId()))
				.body(response);
	}
	
	@PutMapping("{id}")
	public EmployeeResponse update(
		@PathVariable Long id, @Valid @RequestBody EmployeeRequest request){
		logger.info("Put method update");
		return employeeService.update(id, request);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		logger.info("Delete method");
		employeeService.deleteById(id);
	}
}
