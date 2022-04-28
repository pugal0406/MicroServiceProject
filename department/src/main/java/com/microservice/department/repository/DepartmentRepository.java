package com.microservice.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.department.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	
}