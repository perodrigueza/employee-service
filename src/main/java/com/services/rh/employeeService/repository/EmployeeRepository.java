package com.services.rh.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.rh.employeeService.model.entity.Address;
import com.services.rh.employeeService.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByAddress(Address address);
}
