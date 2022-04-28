package com.microservice.employee.service;

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

import com.microservice.employee.entity.Employee;
import com.microservice.employee.entity.EmployeeSignUp;
import com.microservice.employee.repository.EmployeeSignUpRepository;


@Service
public class EmployeeSignUpServiceImp implements EmployeeSignUpService{
	
	@Autowired
	EmployeeSignUpRepository employeeSignUpRepository;
	
	
	
	
	
	@Override
	public EmployeeSignUp createEmployeeSignUp(EmployeeSignUp e){
		
		
		return employeeSignUpRepository.save(e);
	}
	
	@Override
	public EmployeeSignUp updateEmployee(int id,EmployeeSignUp e){
		Optional<EmployeeSignUp> empChack = employeeSignUpRepository.findById(id);
		if(!empChack.isPresent()) {
			return null;
		}
		e.setId(id);
		return employeeSignUpRepository.save(e);
	}
	
	@Override
	public EmployeeSignUp insertOrUpdateEmployee(EmployeeSignUp e){
		return employeeSignUpRepository.save(e);
	}
	
	@Override
	public boolean deleteEmployee(int id){
		Optional<EmployeeSignUp> empChack = employeeSignUpRepository.findById(id);
		if(!empChack.isPresent()) {
			return false;
		}else {
			employeeSignUpRepository.deleteById(id);
			return true;
		}
	}
	
	@Override
	public List<EmployeeSignUp> selectEmployee(){
		return employeeSignUpRepository.findAll();
	}
	
	@Override
	public EmployeeSignUp selectEmployeeById(int id){
		Optional<EmployeeSignUp> empChack = employeeSignUpRepository.findById(id);
		if(!empChack.isPresent()) {
			return null;
		}else {
			return empChack.get();
		}
	}

	@Override
	public List<EmployeeSignUp> selectPatientByCriteria(EmployeeSignUp employee){
		List<EmployeeSignUp> allEmployee = employeeSignUpRepository.findAll();
		
		if(employee.getId()== 0);
		else{
			for(Iterator<EmployeeSignUp> it = allEmployee.listIterator(); it.hasNext();){
				if(it.next().getId()!=employee.getId())
					it.remove();
			}
			if(allEmployee.isEmpty())
				return null;
		}
		
		if(employee.getFname()=="");
		else{
			for(Iterator<EmployeeSignUp> it = allEmployee.listIterator(); it.hasNext();){
				if(it.next().getFname().equals(employee.getFname()));
				else{
					it.remove();
				}
			}
			if(allEmployee.isEmpty())
				return null;
		}
		
		return allEmployee;
		
	}
	
}