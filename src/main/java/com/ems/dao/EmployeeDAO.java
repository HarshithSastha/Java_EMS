package com.ems.dao;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeDAO {
	
	public void add(Employee employee);
	public List<Employee> get();

}
