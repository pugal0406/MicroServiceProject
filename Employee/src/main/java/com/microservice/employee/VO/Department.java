package com.microservice.employee.VO;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Department implements Serializable{


	private int deptid;
   private String deptName;
   private String deptCompany;
   private int empId;
   
   
   public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}

public String getDeptCompany() {
	return deptCompany;
}

public void setDeptCompany(String deptCompany) {
	this.deptCompany = deptCompany;
}



	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
		

}