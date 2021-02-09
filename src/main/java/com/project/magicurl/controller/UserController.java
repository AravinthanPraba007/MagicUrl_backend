package com.project.magicurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.magicurl.model.UserRegisterRequest;
import com.project.magicurl.model.UserRegisterResponse;
import com.project.magicurl.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserRegisterResponse> userRegisteration(@RequestBody UserRegisterRequest request) {
		return userService.registerUser(request);
	}
}
