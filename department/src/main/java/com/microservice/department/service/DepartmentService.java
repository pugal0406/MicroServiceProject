package com.microservice.department.service;

import java.util.List;
import java.util.Optional;

import com.microservice.department.entity.Department;


public interface DepartmentService {

	public Department insertDepartment(Department e);
	public Department updateEmployee(int id,Department e);
	public Department insertOrUpdateEmployee(Department e);
	public void deleteEmployee(int id);
	
	public List<Department> selectEmployee();
	public Department selectEmployeeById(int id);
	public List<Department> selectPatientByCriteria(Department employee);
}