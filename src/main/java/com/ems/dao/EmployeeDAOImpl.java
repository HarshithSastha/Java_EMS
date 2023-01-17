package com.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.*;

import com.ems.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	 EntityManager entityManager;
	
	public void add(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		// code
		 System.out.println("In EmployeeDAO Impl" + employee);
		 session.save(employee);
	}

	@Override
	public List<Employee> get() {
		Session currentSession=entityManager.unwrap(Session.class);
		String s="from Employee";
		
		Query<Employee> query =currentSession.createQuery(s,Employee.class);
		
	 List<Employee> employees= query.getResultList();
		
		return employees;
	
	}
}
