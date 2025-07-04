package com.services.rh.employeeService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.services.rh.employeeService.model.dto.AddressResponse;
import com.services.rh.employeeService.model.entity.Address;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
	
	AddressResponse toAddressResponse(Address address);
}
