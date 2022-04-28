package com.microservice.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservice.employee.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("SELECT u FROM Employee u where u.course=:c")
	public List<Employee> findByCourse(@Param("c")String course);
	
	@Query("SELECT u FROM Employee u")
	public List<Employee> findAllCourse();
	
	
//	@Query("SELECT u.department FROM Employee u")
//	public List<Employee> findByDepartment();
//	
	
//	public Optional<Employee> finByEmpId(int id);



	public Employee findById(int userId);
	
}