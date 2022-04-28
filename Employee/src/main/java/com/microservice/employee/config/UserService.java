package com.microservice.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.employee.entity.EmployeeSignUp;
import com.microservice.employee.repository.EmployeeRepository;
import com.microservice.employee.repository.EmployeeSignUpRepository;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private EmployeeSignUpRepository repo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
EmployeeSignUp user=repo.findByEmail(userName);
        return new User(user.getEmail(),user.getPassword(), new ArrayList<>());
        		}
}