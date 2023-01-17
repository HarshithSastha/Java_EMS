package com.ems.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RestController
public class EmployeeController {
	
	  @Autowired
	  private EmployeeService employeeService;
	
	@RequestMapping("/employees")
	 public String getUserInfo() {
		 
		 return "Hello!I am from employees";
	 }
	
	@PostMapping("/register")
	 public void register(@RequestBody Employee employee) {
		System.out.println(employee.getName());
		System.out.println(employee.getProject());
		employeeService.add(employee);
	 }
	
	 @GetMapping("/list")
	public List<Employee> list() {
		return  employeeService.get();
	}

	
}
