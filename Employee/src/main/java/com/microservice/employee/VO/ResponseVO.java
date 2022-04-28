package com.microservice.employee.VO;

import com.microservice.employee.entity.Employee;

public class ResponseVO {

    private Employee employee;
    public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	private Department department;
}
