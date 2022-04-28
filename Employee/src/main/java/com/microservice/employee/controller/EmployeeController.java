package com.microservice.employee.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.employee.VO.ResponseVO;
import com.microservice.employee.entity.Employee;
import com.microservice.employee.exception.EmptyException;
import com.microservice.employee.repository.EmployeeRepository;
import com.microservice.employee.service.EmployeeServiceImp;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController extends HttpServlet{

	@Autowired
	EmployeeServiceImp employeeServiceImp;
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<Object> goIndex() {
		List<Employee> employees = employeeServiceImp.selectEmployee();		
		employees.forEach(e->{System.out.println(e.getAddress());});

		Set<Employee> set = employees.stream() .collect(Collectors.toCollection(() ->
		new TreeSet<>(Comparator.comparing(Employee::getName))));
		return new ResponseEntity<Object>(employees,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/listRes", method=RequestMethod.GET)
	public ResponseVO employeeList() {
		
		return employeeServiceImp.selectEmployeeWithDepartment();
		
	}
	

	@RequestMapping(value="/insertPage", method=RequestMethod.GET)
	public ResponseEntity<Object> addArticle() {
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> addArticle(@PathVariable("id") int id) {
		
		Employee e = employeeServiceImp.selectEmployeeById(id);		
		return new ResponseEntity<Object>(e,HttpStatus.OK);
	}
	
	
	
	

	@RequestMapping(value="/course", method=RequestMethod.GET)
	public List<Employee> employee() throws ParseException, IOException {
		List<Employee> employees=employeeRepository.findAllCourse();
		return employees;
	}
	
	
	@RequestMapping(value="/course/{course}", method=RequestMethod.GET)
	public List<Employee> course(@PathVariable ("course") String course) throws ParseException, IOException {
		List<Employee> employees=employeeRepository.findByCourse(course);
		return employees;
	}
	
	@RequestMapping(value="/insertPage", method=RequestMethod.POST)
	public ResponseEntity<Employee> insertEmployee(			
			@RequestBody Employee employeeBO,BindingResult result, HttpServletRequest request, HttpServletResponse res,HttpSession session) throws ParseException, IOException {
		if(employeeBO.getName().isEmpty() || employeeBO.getName().length()==0) {
			throw new EmptyException("601","Input field are empty");
		}
		employeeBO=employeeServiceImp.insertEmployee(employeeBO);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public void deleteEmployee(@PathVariable("id") int id) {
	
		employeeServiceImp.deleteEmployeeId(id);
}
	
	@RequestMapping(value="/deleteRes/{id}", method=RequestMethod.GET)
	public void deleteEmployeeRes(@PathVariable("id") int id) {
	System.out.println("id--->"+id);
		 employeeServiceImp.deleteEmployee(id);
}
	

	@RequestMapping(value="/logout", method=RequestMethod.GET)  
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
		if (auth != null){      
			new SecurityContextLogoutHandler().logout(request, response, auth);  
		}  
		return "redirect:/";  
	}  
	
	
	@GetMapping("/{id}")
    public ResponseVO getUserWithDepartment(@PathVariable("id") int userId) {
//        log.info("Inside getUserWithDepartment of UserController");
        return employeeServiceImp.getUserWithDepartment(userId);
    }
	
	
	@PostMapping("/insertEmployee")
    public ResponseVO insertEmployee(@RequestBody ResponseVO responseVO) {
//        log.info("Inside getUserWithDepartment of UserController");
        return employeeServiceImp.insertEmployee(responseVO);
    }
	
	
	
}