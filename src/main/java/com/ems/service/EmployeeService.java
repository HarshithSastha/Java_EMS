package com.ems.service;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeService {
	
	public List<Employee> get();
	public void add(Employee employee);

}
