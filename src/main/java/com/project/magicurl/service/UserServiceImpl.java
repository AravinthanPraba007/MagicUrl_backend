package com.project.magicurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.magicurl.constant.MagicUrlConstant;
import com.project.magicurl.entity.User;
import com.project.magicurl.model.UserRegisterRequest;
import com.project.magicurl.model.UserRegisterResponse;
import com.project.magicurl.model.UserSignInRequest;
import com.project.magicurl.model.UserSignInResponse;
import com.project.magicurl.repository.UserDataRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDataRepository userRepo;

	@Override
	public ResponseEntity<UserRegisterResponse> registerUser(UserRegisterRequest request) {
		// TODO Auto-generated method stub
		UserRegisterResponse response = new UserRegisterResponse();
		if(!isUserNameAvailable(request.getUserName())) {
			response.setResponse_message(MagicUrlConstant.USERNAME_NOT_AVAILABALE);
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
		User db_data = userRepo.findByUserName(userName);
		if(db_data==null || db_data.getUser_name()==null || db_data.getUser_name().isEmpty())
			return true;
		return false;
	}

	@Override
	public UserRegisterResponse insertUserIntoDb(UserRegisterRequest request) {
		// TODO Auto-generated method stub
		User db_data = new User();
		db_data.setUser_name(request.getUserName());
		db_data.setPassword(request.getPassword());
		User db_response = userRepo.save(db_data);
		UserRegisterResponse response = new UserRegisterResponse();
		if(db_response.getUser_name()!= null || !db_response.getUser_name().isEmpty())
		response.setResponse_message(MagicUrlConstant.SUCCESS_USER_REGISTERED);
		return response;
	}

	@Override
	public ResponseEntity<UserSignInResponse> authenticateUser(UserSignInRequest request) {
		// TODO Auto-generated method stub
		UserSignInResponse response_data = new UserSignInResponse();
		User db_data = new User();
		db_data = getUserFromDb(request);
		if(db_data==null) {
			response_data.setResponse_message(MagicUrlConstant.USERNAME_INVALID);
			return new ResponseEntity<>(response_data,HttpStatus.BAD_REQUEST);
		}
		if(!MagicUrlConstant.SIGN_IN_SUCESS_MSG.equals(validateUser(request, db_data))) {
			response_data.setResponse_message(MagicUrlConstant.PASSWORD_INVALID);
			return new ResponseEntity<>(response_data,HttpStatus.BAD_REQUEST);
		}
		response_data.setUser_name(db_data.getUser_name());
		response_data.setResponse_message(MagicUrlConstant.SIGN_IN_SUCESS_MSG);
		return new ResponseEntity<>(response_data,HttpStatus.OK);
	}

	@Override
	public User getUserFromDb(UserSignInRequest userRequest) {
		// TODO Auto-generated method stub
		User db_data = userRepo.findByUserName(userRequest.getUser_name());
		if(db_data==null || db_data.getUser_name()==null || db_data.getUser_name().isEmpty())
			return null;
		return db_data;
	}

	@Override
	public String validateUser(UserSignInRequest userRequest, User dbResponse) {
		/**
		 * Current validation is password level
		 */
		if(userRequest.getPassword().equals(dbResponse.getPassword()))
			return MagicUrlConstant.SIGN_IN_SUCESS_MSG;
		else 
			return MagicUrlConstant.PASSWORD_INVALID;
	}

}
