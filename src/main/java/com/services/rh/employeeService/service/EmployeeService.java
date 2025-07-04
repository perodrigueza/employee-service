package com.services.rh.employeeService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.services.rh.employeeService.model.dto.EmployeeRequest;
import com.services.rh.employeeService.model.dto.EmployeeResponse;

public interface EmployeeService {

	EmployeeResponse findById(Long id);
	
	List<EmployeeResponse> findAll();
	
	EmployeeResponse findByAddressId(Long id);
	
	EmployeeResponse save(EmployeeRequest employeeRequest);
	
	EmployeeResponse update(Long id, EmployeeRequest employeeRequest);
	
	void deleteById(Long id);
}
