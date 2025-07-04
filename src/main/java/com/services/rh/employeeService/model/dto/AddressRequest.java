package com.services.rh.employeeService.model.dto;

import com.services.rh.employeeService.model.entity.Employee;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressRequest {
	
	@NotEmpty (message = "El campo street no puede estar vacío o nulo")
	private String street;
	
	@NotEmpty (message = "El campo number no puede estar vacío o nulo")
	private String number;
	
	@NotEmpty (message = "El campo state no puede estar vacío o nulo")
	private String state;
	
	@NotEmpty (message = "El campo region no puede estar vacío o nulo")
	private String region; 
	
	@NotEmpty (message = "El campo cp no puede estar vacío o nulo")
	private String cp;
}
