package com.services.rh.employeeService.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class EmployeeResponse {
	
	private String id;
	private String frstName;
	private String lastName;
	private String surName;
	private String birthDate;
	private String nationality;
	private String gender;
	private String rfc; 
	private AddressResponse address;
}
