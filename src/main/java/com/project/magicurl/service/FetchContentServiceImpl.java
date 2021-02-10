package com.project.magicurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.magicurl.constant.MagicUrlConstant;
import com.project.magicurl.entity.MagicUrl;
import com.project.magicurl.model.FetchContentResponse;
import com.project.magicurl.repository.MagicUrlRepository;

@Service
public class FetchContentServiceImpl implements FetchContentService{

	@Autowired
	MagicUrlRepository magicUrlRepo;
	@Override
	public ResponseEntity<FetchContentResponse> fetchContent(String url) {
		// TODO Auto-generated method stub
		FetchContentResponse response = new FetchContentResponse(); 
		response = retriveContentFromDB(url);
		if(response.getContent()==null) {
			response .setResponse_message(MagicUrlConstant.INVALID_URL);
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		if(isContentExpired(response.getExpiry_time())) {
			response .setResponse_message(MagicUrlConstant.EXPIRED_URL);
			return new ResponseEntity<>(response,HttpStatus.GONE);
		}
		response.setResponse_message(MagicUrlConstant.SUCCESS_FETCH_CONTENT);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@Override
	public boolean isContentExpired(Integer expiryTime) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public FetchContentResponse retriveContentFromDB(String url) {
		// TODO Auto-generated method stub
		MagicUrl db_fetch = magicUrlRepo.findMagicUrlByShortUrl(url);
		if(db_fetch==null)
		return null;
		FetchContentResponse db_response = new FetchContentResponse();
		db_response.setContent(db_fetch.getContent());
		db_response.setContent_type(db_fetch.getContent_type());
		db_response.setExpiry_time(10);
		return db_response;
	}

}
