package com.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.User;
import com.ems.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	
	@Autowired
	  UserService userService;
	
	@PostMapping("/add")
	 public ResponseEntity<Boolean> add(@RequestBody User user) {
		
		   boolean response =  userService.add(user);
		   
		   if(response == true) {
			   
			   return new ResponseEntity<Boolean>(response,HttpStatus.OK);
		   }
		   else {
			   return new ResponseEntity<Boolean>(response,HttpStatus.BAD_REQUEST);
		   }
		 
	 }
	
	@PutMapping("/update")
	 public void update(@RequestBody User user) {
		   userService.update(user);
	 }


	
	@GetMapping("/getById")
	 public ResponseEntity<User> userById(@RequestBody User user) {
		
		  User result =  userService.getByid(user.getUserid());
		  
		  return new ResponseEntity<User>(result, HttpStatus.OK);
	 }
	
	@GetMapping("/list")
	 public ResponseEntity<List<User>> getAllProducts() {
		 List<User> result =  userService.get();
		  return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	 }
	
	
}
