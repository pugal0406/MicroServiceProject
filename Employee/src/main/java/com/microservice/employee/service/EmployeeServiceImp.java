package com.microservice.employee.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.microservice.employee.VO.Department;
import com.microservice.employee.VO.ResponseVO;
import com.microservice.employee.entity.Employee;
import com.microservice.employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private RestTemplate restTemplate;
		
	@Override
	public Employee insertEmployee(Employee e){
		
		return employeeRepository.save(e);
	}
	
	@Override
	public Employee updateEmployee(int id,Employee e){
//		Employee empChack = employeeRepository.findById(id);
		
//		 Department dept=restTemplate.postForObject("http://department/departments",empChack,Department.class);
		 

	
		e.setId(id);
		return employeeRepository.save(e);
	}
	
	@Override
	public Employee insertOrUpdateEmployee(Employee e){
		return employeeRepository.save(e);
	}
	
	
	
	@Override
	public List<Employee> selectEmployee(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee selectEmployeeById(int id){
		Employee empChack = employeeRepository.findById(id);
		return empChack;
		
	}
	@Override
	public ResponseVO deleteEmployee(int id) {
		// TODO Auto-generated method stub
		ResponseVO vo = new ResponseVO();
		System.out.println("id---1>"+id);
		employeeRepository.deleteById(id);
		System.out.println("id---1>"+id);
		Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departmentService/deleteRes/" + id
                        ,Department.class);
vo.setDepartment(department);

		return vo;
	}

	
	  public ResponseVO getUserWithDepartment(int userId) {
//        log.info("Inside getUserWithDepartment of UserService");
        ResponseVO vo = new ResponseVO();
        Employee user = employeeRepository.findById(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departmentService/" + user.getId()
                        ,Department.class);

        vo.setEmployee(user);
        vo.setDepartment(department);

        return  vo;
    }
	  
	  
	  public ResponseVO insertEmployee(ResponseVO responseVO) {
		  ResponseVO vo = new ResponseVO();
          Employee employee=responseVO.getEmployee();
          Department department=responseVO.getDepartment();
          department.setEmpId(employee.getId());
         department= restTemplate.postForObject("http://DEPARTMENT-SERVICE/departmentService/create", department, Department.class);
          employeeRepository.save(employee);
          vo.setEmployee(employee);
          vo.setDepartment(department);
          return vo;
    }
	  
	  

	@Override
	public void deleteEmployeeId(int id) {
		// TODO Auto-generated method stub
		 employeeRepository.deleteById(id);
		
	}

	public ResponseVO selectEmployeeWithDepartment() {
		// TODO Auto-generated method stub
		List<ResponseVO> vo = new ArrayList<ResponseVO>();
		List<Employee> e=employeeRepository.findAll();
		Iterator<Employee> itr=e.iterator();
		((Iterator<Employee>) e).forEachRemaining(System.out::println);


		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//person list
//		List<Employee> personList = new ArrayList<Employee>();
		
		//httpEnitity       
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(e,headers);
		
		/*
		 * ResponseEntity<Department> department =
		 * restTemplate.getForEntity("http://localhost:8081/departmentService/" + e
		 * ,ResponseEntity<Department>.class);
		 */

		
		return null;
	}

	@Override
	public List<Employee> findByCourse(String course) {
		// TODO Auto-generated method stub
		return employeeRepository.findByCourse(course);
	}	
	
	
	@Override
	public List<Employee> findAllCourse() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllCourse();
	}	
	
	
	

	
}