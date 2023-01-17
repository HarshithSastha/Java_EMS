package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	 private EmployeeDAO employeeDAO;
	
	@Transactional
	public void add(Employee employee) {
		// code
		 System.out.println("In EmployeeService Impl" + employee);
		employeeDAO.add(employee);
	}
	
	@Transactional
	public List<Employee> get() {
	        return employeeDAO.get();	
		
	}
}
