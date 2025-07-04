package com.services.rh.employeeService.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.services.rh.employeeService.exceptions.AddressNotFoundException;
import com.services.rh.employeeService.exceptions.EmployeeNotFoundException;
import com.services.rh.employeeService.model.dto.ErrorResponse;

import static com.services.rh.employeeService.utils.ErrorCatalog.EMPLOYEE_NOT_FOUND;
import static com.services.rh.employeeService.utils.ErrorCatalog.ADDRESS_NOT_FOUND;
import static com.services.rh.employeeService.utils.ErrorCatalog.EMPLOYEE_INVALID;
import static com.services.rh.employeeService.utils.ErrorCatalog.GENERIC_ERROR;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	private static final Logger logger = LogManager.getLogger(GlobalControllerAdvice.class);
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ErrorResponse handleEmployeeNotFoundException() {
		logger.error("Empleado no encontrado");
		return ErrorResponse.builder()
				.code(EMPLOYEE_NOT_FOUND.getCode())
				.status(HttpStatus.NOT_FOUND)
				.message(EMPLOYEE_NOT_FOUND.getMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(AddressNotFoundException.class)
	public ErrorResponse handleAddressNotFoundException() {
		logger.error("Dirección no encontrada");
		return ErrorResponse.builder()
				.code(ADDRESS_NOT_FOUND.getCode())
				.status(HttpStatus.NOT_FOUND)
				.message(ADDRESS_NOT_FOUND.getMessage())
				.timeStamp(LocalDateTime.now())
				.build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		BindingResult result = exception.getBindingResult();
		logger.error("Petición errónea", exception);
		return ErrorResponse.builder()
				.code(EMPLOYEE_INVALID.getCode())
				.status(HttpStatus.BAD_REQUEST)
				.message(EMPLOYEE_INVALID.getMessage())
				.detailMessages(result.getFieldErrors()
					.stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList()))
				.timeStamp(LocalDateTime.now())
				.build();
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErrorResponse handleInternalServerError(Exception exception) {
		logger.error("Internal Server Error", exception);
		return ErrorResponse.builder()
				.code(GENERIC_ERROR.getCode())
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message(GENERIC_ERROR.getMessage())
				.detailMessages(Collections.singletonList(exception.getMessage()))
				.timeStamp(LocalDateTime.now())
				.build();
	}
}

