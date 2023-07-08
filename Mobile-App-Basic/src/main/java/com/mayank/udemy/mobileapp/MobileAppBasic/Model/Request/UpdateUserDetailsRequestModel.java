package com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

	@NotNull(message="first name cannot be null")
	@Size(min=2, message="firstname must be greater than 2 characters")
	private String firstName;
	
	@NotNull(message="last name cannot be null")
	@Size(min=2, message="lastname must be greater than 2 characters")
	private String lastName;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
