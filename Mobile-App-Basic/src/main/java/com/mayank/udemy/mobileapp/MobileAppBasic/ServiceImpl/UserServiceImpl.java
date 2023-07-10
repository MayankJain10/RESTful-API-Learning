package com.mayank.udemy.mobileapp.MobileAppBasic.ServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request.UpdateUserDetailsRequestModel;
import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Request.UserDetails;
import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Response.Users;
import com.mayank.udemy.mobileapp.MobileAppBasic.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	Map<String, Users>user = null;

	@Override
	public Users createUser(UserDetails userDetails) {
		Users userInfo = new Users();

		userInfo.setFirstName(userDetails.getFirstName());
		userInfo.setLastName(userDetails.getLastName());
		userInfo.setEmail(userDetails.getEmail());
		
		String userId = UUID.randomUUID().toString();
		userInfo.setUserId(userId);
		
		if(user==null) {
			user = new HashMap<>();
			user.put(userId, userInfo);
		}
		return userInfo;
	}

	@Override
	public Users updateUser(String userId, UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
		
		Users storedUserDetails = user.get(userId);
		storedUserDetails.setFirstName(updateUserDetailsRequestModel.getFirstName());
		storedUserDetails.setLastName(updateUserDetailsRequestModel.getLastName());
		 
		user.put(userId, storedUserDetails);
		
		return storedUserDetails;
	}
	

}
