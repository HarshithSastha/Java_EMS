package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.ProductDAO;
import com.ems.model.Product;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDAO;
	

    @Transactional
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		  return productDAO.add(product);
	}

    @Transactional
	public List<Product> get() {
		// TODO Auto-generated method stub
		return productDAO.get();
	}

    @Transactional
	public Product getByid(int id) {
		// TODO Auto-generated method stub
		return productDAO.getByid(id);
	}

    @Transactional
	public void update(Product product) {
		// TODO Auto-generated method stub
    	productDAO.update(product);
		
	}

    @Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
    	System.out.println("service");
    	productDAO.delete(id);
		
	}
	

}
