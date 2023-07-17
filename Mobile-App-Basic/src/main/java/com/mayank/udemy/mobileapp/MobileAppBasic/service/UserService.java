package com.mayank.udemy.mobileapp.MobileAppBasic.service;

import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request.UpdateUserDetailsRequestModel;
import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request.UserDetails;
import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Response.Users;

public interface UserService {
	
	Users createUser(UserDetails userDetails);
	
	Users updateUser(String userId, UpdateUserDetailsRequestModel updateUserDetailsRequestModel);

}
