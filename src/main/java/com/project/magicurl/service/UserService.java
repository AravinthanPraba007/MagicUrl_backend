package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;

import com.project.magicurl.model.UserRegisterRequest;
import com.project.magicurl.model.UserRegisterResponse;
import com.project.magicurl.model.UserSignInRequest;
import com.project.magicurl.model.UserSignInResponse;

public interface UserService {

	public ResponseEntity<UserRegisterResponse> registerUser(UserRegisterRequest request);
	
	public boolean isUserNameAvailable(String userName);
	
	public UserRegisterResponse insertUserIntoDb(UserRegisterRequest request);
	
	public ResponseEntity<UserSignInResponse> authenticateUser(UserSignInRequest request);
	
	public UserSignInResponse getUserFromDb(UserSignInRequest userRequest);
	
	public String validateUser(UserSignInRequest userRequest, UserSignInRequest dbResponse);

}
