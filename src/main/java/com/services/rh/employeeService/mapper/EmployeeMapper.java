package com.services.rh.employeeService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.services.rh.employeeService.model.dto.EmployeeResponse;
import com.services.rh.employeeService.model.entity.Employee;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = AddressMapper.class)
public interface EmployeeMapper {
	
	EmployeeResponse toEmployeeResponse(Employee employee);

}
