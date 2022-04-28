package com.microservice.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservice.employee.entity.Employee;
import com.microservice.employee.entity.EmployeeSignUp;

public interface EmployeeSignUpRepository extends JpaRepository<EmployeeSignUp, Integer>{
	@Query("SELECT u FROM EmployeeSignUp u WHERE u.email = ?1")
	public EmployeeSignUp findByEmail(String email);
	
}
