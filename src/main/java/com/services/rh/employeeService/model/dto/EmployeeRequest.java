package com.services.rh.employeeService.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeRequest {
	
	@NotEmpty (message = "El campo firstName no puede estar vacío o nulo")
	private String firstName;
	
	@NotEmpty (message = "El campo lastName no puede estar vacío o nulo")
	private String lastName;
	
	@NotEmpty (message = "El campo surName no puede estar vacío o nulo")
	private String surName;
	
	@NotEmpty (message = "El campo birthDate no puede estar vacío o nulo")
	private Date birthDate;
	
	@NotEmpty (message = "El campo nationality no puede estar vacío o nulo")
	private String nationality;
	
	@NotEmpty (message = "El campo gender no puede estar vacío o nulo")
	private String gender;
	
	@NotEmpty (message = "El campo rfc no puede estar vacío o nulo")
	private String rfc; 
	
	@NotEmpty (message = "El campo address no puede ser nulo")
	private Long addressId;
}
