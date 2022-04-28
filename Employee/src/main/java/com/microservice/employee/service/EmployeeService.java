package com.microservice.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.microservice.employee.VO.ResponseVO;
import com.microservice.employee.entity.Employee;


public interface EmployeeService {

	public Employee insertEmployee(Employee e);
	public Employee updateEmployee(int id,Employee e);
	public Employee insertOrUpdateEmployee(Employee e);
	public void deleteEmployeeId(int id);
	public ResponseVO deleteEmployee(int id);
	
	public List<Employee> findByCourse(String course);
	public List<Employee> findAllCourse();
	
	public List<Employee> selectEmployee();
	public Employee selectEmployeeById(int id);
	
	
	
}