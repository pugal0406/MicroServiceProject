package com.microservice.department.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.microservice.department.entity.Department;
import com.microservice.department.repository.DepartmentRepository;


@Service
public class DepartmentServiceImp implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;
		
	@Override
	public Department insertDepartment(Department e){
		//Department emp=new Department();
		e.getDeptName();
		e.getDeptCompany();
		e.getEmpId();
		return departmentRepository.save(e);
	}
	
	@Override
	public Department updateEmployee(int id,Department e){
		Optional<Department> empChack = departmentRepository.findById(id);
		if(!empChack.isPresent()) {
			return null;
		}
		e.setDeptid(id);
		return departmentRepository.save(e);
	}
	
	@Override
	public Department insertOrUpdateEmployee(Department e){
		return departmentRepository.save(e);
	}
	
	
	
	@Override
	public List<Department> selectEmployee(){
		return departmentRepository.findAll();
	}
	
	@Override
	public Department selectEmployeeById(int id){
		Department empChack = departmentRepository.findById(id).get();
		return empChack;
		
	}

	@Override
	public List<Department> selectPatientByCriteria(Department employee){
		List<Department> allEmployee = departmentRepository.findAll();
		
		if(employee.getDeptid()== 0);
		else{
			for(Iterator<Department> it = allEmployee.listIterator(); it.hasNext();){
				if(it.next().getDeptid()!=employee.getDeptid())
					it.remove();
			}
			if(allEmployee.isEmpty())
				return null;
		}
		
		if(employee.getDeptName()=="");
		else{
			for(Iterator<Department> it = allEmployee.listIterator(); it.hasNext();){
				if(it.next().getDeptName().equals(employee.getDeptName()));
				else{
					it.remove();
				}
			}
			if(allEmployee.isEmpty())
				return null;
		}
		
		if(employee.getDeptCompany()=="");
		else{
			for(Iterator<Department> it = allEmployee.listIterator(); it.hasNext();){
				if(it.next().getDeptCompany().equals(employee.getDeptCompany()));
				else{
					it.remove();
				}
			}
			if(allEmployee.isEmpty())
				return null;
		}
		
				return allEmployee;
		
	}


	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		System.out.println("id---4>"+id);
		departmentRepository.deleteById(id);
		System.out.println("id---4>"+id);
	}


	
}