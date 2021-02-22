package com.project.magicurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.magicurl.model.UserRegisterRequest;
import com.project.magicurl.model.UserRegisterResponse;
import com.project.magicurl.model.UserSignInRequest;
import com.project.magicurl.model.UserSignInResponse;
import com.project.magicurl.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserRegisterResponse> userRegisteration(@RequestBody UserRegisterRequest request) {
		return userService.registerUser(request);
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<UserSignInResponse> userSignIn(@RequestBody UserSignInRequest request) {
		return userService.authenticateUser(request);
	}
}
