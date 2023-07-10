package com.mayank.udemy.mobileapp.MobileAppBasic.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.udemy.mobileapp.MobileAppBasic.Exception.UserServiceException;
import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request.UpdateUserDetailsRequestModel;
import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request.UserDetails;
import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Response.Users;
import com.mayank.udemy.mobileapp.MobileAppBasic.ServiceImpl.UserServiceImpl;
import com.mayank.udemy.mobileapp.MobileAppBasic.service.UserService;

/**
 * 
 * @author mayank 
 * Rest controller to learn more about RESTful api. 
 * ( GET, POST, PUT, DELETE )
 * 
 */
@RestController
@RequestMapping(value = "api") // http://localhost:8080
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Map<String, Users>user = null;

	/**
	 * Using pathVariable, method to get the details of user by userId in path
	 * variable.
	 * Learned the use of ResponseEntity to return the response.
	 * used model class and set the details in it and send the response.
	 * set the Status code
	 * 
	 * @param userId
	 * @return userId
	 */

	@GetMapping(path = "get/User/Details/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Users> getUser(@PathVariable String userId) {

		/*Users userInfo = new Users();

		userInfo.setFirstName("");
		userInfo.setLastName("Jain");
		userInfo.setEmail("Mayank.Jain@airlinq.com");*/
		
		/*String firstName = null;
		//
		//
		int firstNameLength = firstName.length();*/
		
		/*if(true) {
			throw new UserServiceException("A user service exception is thrown");
		}*/
		
		if(user.containsKey(userId)) {
			return new ResponseEntity<>(user.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		
	}

	/**
	 * Concept of query String parameters. In this method pass the value in query
	 * String parameters. page and limit are the query string parameters and by
	 * default required true.
	 * 
	 * required=false, is use with the String type parameters, if we use with the
	 * int type then it gives error, because it cannot translate to null.
	 * 
	 * @param page
	 * @param limit
	 * @return users with limit
	 */

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

		return "get user was called with page = " + page + ", limit = " + limit + "and sort = " + sort;
	}
	
	/**
	 * Using valid annotation to validate the fields, 
	 * Storing the value temporarily in the map after creating user,
	 * Map is declared on the top of all the methods.
	 * UserDetails model class is used.
	 * 
	 * @param userDetails
	 * @return user information
	 */

	@PostMapping(path = "create/User", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
				 produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Users> createUser(@Valid @RequestBody UserDetails userDetails) {
		
		Users returnValue = userService.createUser(userDetails);
		
		return new ResponseEntity<Users>(returnValue, HttpStatus.OK);
	}
	
	/**
	 * Update user details method,
	 * updating user details on the basis of userId
	 * Fetching details from the temporarily map, and then on the basis of userId updating
	 * the first name and last name.
	 * 
	 * @param userId
	 * @param updateUserDetailsRequestModel
	 * @return updated user details
	 */

	@PutMapping(path = "update/User/Details/{userId}",consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
				 produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Users updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
		
		Users returnValue = userService.updateUser(userId, updateUserDetailsRequestModel);

		return returnValue;
	}

	@DeleteMapping(path = "delete/User/Details/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {

		user.remove(id);
		return ResponseEntity.noContent().build();
	}

}
