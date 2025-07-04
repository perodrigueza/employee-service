package com.services.rh.employeeService.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.services.rh.employeeService.exceptions.AddressNotFoundException;
import com.services.rh.employeeService.exceptions.EmployeeNotFoundException;
import com.services.rh.employeeService.mapper.EmployeeMapper;
import com.services.rh.employeeService.model.dto.EmployeeRequest;
import com.services.rh.employeeService.model.dto.EmployeeResponse;
import com.services.rh.employeeService.model.entity.Employee;
import com.services.rh.employeeService.repository.AddressRepository;
import com.services.rh.employeeService.repository.EmployeeRepository;
import com.services.rh.employeeService.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);
	
	private final EmployeeRepository employeeRepository;
	
	private final AddressRepository addressRepository;
	
	private final EmployeeMapper employeeMapper;

	@Override
	public List<EmployeeResponse> findAll() {
		logger.info("EmployeeServiceImpl findAll");
		return employeeRepository.findAll()
				.stream()
				.map(employeeMapper::toEmployeeResponse)
				.collect(Collectors.toList());
	}
	
	@Override
	public EmployeeResponse findById(Long id) {
		logger.info("EmployeeServiceImpl findById id="+id);
		return employeeRepository.findById(id)
				.map(employeeMapper::toEmployeeResponse)
				.orElseThrow(EmployeeNotFoundException::new);
	}

	@Override
	public EmployeeResponse save(EmployeeRequest employeeRequest) {
		logger.info("EmployeeServiceImpl save");
		return addressRepository.findById(employeeRequest.getAddressId())
				.map(address -> {
					Employee employee= new Employee();
					employee.setFirstName(employeeRequest.getFirstName());
					employee.setLastName(employeeRequest.getLastName());
					employee.setSurName(employeeRequest.getSurName());
					employee.setBirthDate(employeeRequest.getBirthDate());
					employee.setNationality(employeeRequest.getNationality());
					employee.setGender(employeeRequest.getGender());
					employee.setRfc(employeeRequest.getRfc());
					employee.setAddress(address);
					return employeeRepository.save(employee);
				})
				.map(employeeMapper::toEmployeeResponse)
				.orElseThrow(AddressNotFoundException::new);
	}

	@Override
	public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
		logger.info("EmployeeServiceImpl update");
		return employeeRepository.findById(id)
				.map(employee -> addressRepository
					.findById(employeeRequest.getAddressId())
					.map(address -> {
						employee.setFirstName(employeeRequest.getFirstName());
						employee.setLastName(employeeRequest.getLastName());
						employee.setSurName(employeeRequest.getSurName());
						employee.setBirthDate(employeeRequest.getBirthDate());
						employee.setNationality(employeeRequest.getNationality());
						employee.setGender(employeeRequest.getGender());
						employee.setRfc(employeeRequest.getRfc());
						employee.setAddress(address);
						return employeeRepository.save(employee);
					})
					.orElseThrow(AddressNotFoundException::new))
				.map(employeeMapper::toEmployeeResponse)
				.orElseThrow(EmployeeNotFoundException::new);
	}

	@Override
	public void deleteById(Long id) {
		logger.info("EmployeeServiceImpl deleteById");
		if(employeeRepository.findById(id).isEmpty()) {
			throw new EmployeeNotFoundException();
		}
		
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeResponse findByAddressId(Long id) {
		logger.info("EmployeeServiceImpl findByAddressId");
		return addressRepository.findById(id)
				.map(employeeRepository::findByAddress)
				.map(employeeMapper::toEmployeeResponse)
				.orElseThrow(EmployeeNotFoundException::new);
				
	}
}
