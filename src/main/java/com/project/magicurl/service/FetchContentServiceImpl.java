package com.project.magicurl.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.magicurl.constant.MagicUrlConstant;
import com.project.magicurl.entity.FetchContentResponse;

public class FetchContentServiceImpl implements FetchContentService{

	@Override
	public ResponseEntity<FetchContentResponse> fetchContent(String url) {
		// TODO Auto-generated method stub
		FetchContentResponse response = new FetchContentResponse();
		if(!isURLprsent(url)) {
			response.setResponse_message(MagicUrlConstant.INVALID_URL);
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		FetchContentResponse db_response = retriveContentFromDB(url);
		if(db_response.getContent()==null || db_response.getContent().isEmpty()) {
			response .setResponse_message(MagicUrlConstant.FETCH_CONTENT_ERROR_MSG);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(isContentExpired(db_response.getExpiry_time())) {
			response .setResponse_message(MagicUrlConstant.EXPIRED_URL);
			return new ResponseEntity<>(response,HttpStatus.GONE);
		}
		return null;
	}

	@Override
	public boolean isURLprsent(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isContentExpired(Integer expiryTime) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public FetchContentResponse retriveContentFromDB(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
