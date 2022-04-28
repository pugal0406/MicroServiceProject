package com.microservice.department.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.microservice.department.entity.Department;
import com.microservice.department.exception.EmptyException;
import com.microservice.department.repository.DepartmentRepository;
import com.microservice.department.service.DepartmentServiceImp;

@RestController
@RequestMapping(value = "/departmentService")
public class DepartmentController extends HttpServlet{

	@Autowired
	DepartmentServiceImp employeeServiceImp;
	@Autowired
	DepartmentRepository employeeRepository;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<Object> goIndex() {
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/listRes", method=RequestMethod.GET)
	public ResponseEntity<Object> deprtList() {
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> addArticle(@PathVariable("id") int id) {
		
		Department e = employeeServiceImp.selectEmployeeById(id);
		
		return new ResponseEntity<Object>(e,HttpStatus.OK);
	}

	
	
	
	@RequestMapping(value="/deleteRes/{id}", method=RequestMethod.GET)
	public void deleteEmployee(@PathVariable("id") int id) {
	System.out.println("id-----3>"+id);
		employeeServiceImp.deleteEmployee(id);
		
	}
	
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<Department> insertEmployee(			
			@RequestBody Department dprt,BindingResult result, HttpServletRequest request, HttpServletResponse res,HttpSession session) throws ParseException, IOException {
		System.out.println("inside department");
		dprt=employeeServiceImp.insertDepartment(dprt);
		return new ResponseEntity<Department>(dprt,HttpStatus.OK);
	}
}