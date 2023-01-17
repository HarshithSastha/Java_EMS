package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.UserDAO;
import com.ems.model.User;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean add(User user) {
		  return userDAO.add(user);
	}

	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		return userDAO.get();
	}

	@Override
	public User getByid(int id) {
		// TODO Auto-generated method stub
		return userDAO.getByid(id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		  userDAO.update(user);
	}
	
	

}
