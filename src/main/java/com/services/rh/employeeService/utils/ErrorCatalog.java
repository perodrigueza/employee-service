package com.services.rh.employeeService.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

	EMPLOYEE_NOT_FOUND("ERR_EMPLOYEE_01", "Empleado no encontrado."),
	EMPLOYEE_INVALID("ERR_EMPLOYEE_02", "Parámetros de Empleado inválidos."),
	ADDRESS_NOT_FOUND("ERR_ADDRESS_01", "Direción no encontrada."),
	GENERIC_ERROR("ERR_GENERIC_01", "Error inesperado.");
	
	private String code;
	private String message;
	
	ErrorCatalog(String code, String message){
		this.code = code;
		this.message = message;
	}
	
}
