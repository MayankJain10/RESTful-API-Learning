package com.mayank.udemy.mobileapp.MobileAppBasic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author mayank
 * Rest controller to learn more about RESTful api.
 * ( GET, POST, PUT, DELETE )
 * 
 */
@RestController
@RequestMapping(value="users") //http://localhost:8080
public class UserController {
	
	/**
	 * Using pathVariable, method to get the details of user by userId in path variable.
	 * @param userId
	 * @return userId
	 */
	
	@GetMapping (path="/{userId}")
	public String getUser(@PathVariable String userId) {
		
		return "get user was called with userId = " + userId; 
	}
	
	/**
	 * Concept of query String parameters.
	 * In this method pass the value in query String parameters.
	 * page and limit are the query string parameters and by default required true. 
	 * @param page
	 * @param limit
	 * @return users with limit
	 */
	
	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			     		   @RequestParam(value = "limit", defaultValue = "50") int limit) {
		
		return "get user was called with page = "+ page + "and limit = " + limit; 
	}
	
	@PostMapping
	public String createUser() {
		
		return "create user was called!";
	}
	
	@PutMapping
	public String updateUser() {
		
		return "update user was called!";
	}
	
	@DeleteMapping
	public String deleteUser() {
		
		return "delete user was called!";
	}

}
