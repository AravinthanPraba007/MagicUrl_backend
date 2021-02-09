package com.project.magicurl.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.magicurl.constant.MagicUrlConstant;
import com.project.magicurl.model.UserRegisterRequest;
import com.project.magicurl.model.UserRegisterResponse;
import com.project.magicurl.model.UserSignInRequest;
import com.project.magicurl.model.UserSignInResponse;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public ResponseEntity<UserRegisterResponse> registerUser(UserRegisterRequest request) {
		// TODO Auto-generated method stub
		UserRegisterResponse response = new UserRegisterResponse();
		if(!isUserNameAvailable(request.getUserName())) {
			response.setResponse_message(MagicUrlConstant.USER_NOT_AVAILABALE);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		UserRegisterResponse db_response = insertUserIntoDb(request);
		if(!db_response.getResponse_message().equals(MagicUrlConstant.SUCCESS_USER_REGISTERED)) {
			response.setResponse_message(MagicUrlConstant.USER_REGISTRATION_ERROR_MSG);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setResponse_message(db_response.getResponse_message());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@Override
	public boolean isUserNameAvailable(String userName) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public UserRegisterResponse insertUserIntoDb(UserRegisterRequest request) {
		// TODO Auto-generated method stub
		UserRegisterResponse db_data = new UserRegisterResponse();
		db_data.setResponse_message(MagicUrlConstant.SUCCESS_USER_REGISTERED);
		return db_data;
	}

	@Override
	public ResponseEntity<UserSignInResponse> authenticateUser(UserSignInRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
