package com.microservice.apiGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFallBackMethod {
	 @GetMapping("/employeeServiceFallBack")
	    public String employeeServiceFallBackMethod() {
	        return "User Service is taking longer than Expected." +
	                " Please try again later";
	    }

	    @GetMapping("/departmentServiceFallBack")
	    public String departmentServiceFallBackMethod() {
	        return "Department Service is taking longer than Expected." +
	                " Please try again later";
	    }


}
