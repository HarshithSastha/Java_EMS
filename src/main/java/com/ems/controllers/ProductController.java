package com.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Product;
import com.ems.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductController {

	
	@Autowired
	  ProductService productService;
	
	@PostMapping("/add")
	 public ResponseEntity add(@RequestBody Product product) {
		
		   boolean response =  productService.add(product);
		   
		   if(response == true) {
			   
			   return new ResponseEntity(response,HttpStatus.OK);
		   }
		   else {
			   return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
		   }
		 
	 }
	
	@PutMapping("/update")
	 public void update(@RequestBody Product product) {
		
		     
		   productService.update(product);
	 }
	@DeleteMapping("/delete")
	public void delete(@RequestBody Product product) {
		System.out.println("controller");
		productService.delete(product.getId());
	}
	
	@GetMapping("/getById")
	 public ResponseEntity<Product> productById(@RequestBody Product product) {
		
		  Product result =  productService.getByid(product.getId());
		  
		  return new ResponseEntity<Product>(result, HttpStatus.OK);
	 }
	
	@GetMapping("/list")
	 public ResponseEntity<List<Product>> getAllProducts() {
		
		  List<Product> result =  productService.get();
		  
		  return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
	 }
	
	
}
