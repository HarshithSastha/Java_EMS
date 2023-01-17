package com.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ems.model.User;

@Repository
public class UserDAOImpl  implements UserDAO{
	
	@Autowired
	 EntityManager entityManager;
		
	@Override
	public boolean add( User user) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		boolean status =  false;
		List<User> list =  get();
		System.out.println("before list"+list.size());
		
		// perform encryption mechanism
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //user.setPassword(encoder.encode(user.getPassword()));
        session.save(user);
        List<User> list2 =  get();
			System.out.println("after list"+list2.size());
			
			if((list.size()+1) == list2.size()) 
			{
			status = true;
			}
			return status; 
	}

	@Override
	public List<User> get()  {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		List<User> list = session.createQuery("from User").list();
		return list;
	}

	@Override
	public User getByid(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		User user =  session.load(User.class, id);
		return user;
	}


	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.update(user);
	}
	
		

}
