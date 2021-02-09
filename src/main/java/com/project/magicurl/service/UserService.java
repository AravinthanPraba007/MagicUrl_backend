package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;

import com.project.magicurl.model.UserRegisterRequest;
import com.project.magicurl.model.UserRegisterResponse;

public interface UserService {

	public ResponseEntity<UserRegisterResponse> registerUser(UserRegisterRequest request);
	
	public boolean isUserNameAvailable(String userName);
	
	public UserRegisterResponse insertUserIntoDb(UserRegisterRequest request);

}
