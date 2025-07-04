package com.services.rh.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.rh.employeeService.model.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
