package com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Entity class or Model class which contains user details for http request
 * method
 * 
 * @author mayank
 *
 */
public class UserDetails {
	
	@NotNull(message="first name cannot be null")
	@Size(min=2, message="firstname must be greater than 2 characters")
	private String firstName;
	
	@NotNull(message="last name cannot be null")
	@Size(min=2, message="lastname must be greater than 2 characters")
	private String lastName;
	
	@Email
	@NotNull(message="email cannot be null")
	private String email;

	@Size(min=8, max=16, message="password must be equal or greater than 8 characters and less than"
			+ "16 characters")
	@NotNull(message= "password cannot be null")
	private String password;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
