package com.ems.dao;

import java.util.List;

import com.ems.model.Product;
import com.ems.model.User;

public interface UserDAO {
	
	public boolean add(User user);
	public List<User> get();
	public User getByid(int id);
	public void update(User user);
	

}
