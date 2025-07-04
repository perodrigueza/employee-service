package com.services.rh.employeeService.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddressResponse {

	private String id;
	private String street;
	private String number;
	private String state;
	private String region; 
	private String cp;
}
