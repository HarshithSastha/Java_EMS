package com.ems.dao;

import java.util.List;

import com.ems.model.Product;

public interface ProductDAO {
	
	public boolean add(Product product);
	public List<Product> get();
	public Product getByid(int id);
	public void update(Product product);
	public void delete(int id);
	

}
