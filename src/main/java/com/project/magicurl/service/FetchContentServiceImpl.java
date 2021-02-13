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
		if(response.isUrlExpired()) {
			response .setResponse_message(MagicUrlConstant.EXPIRED_URL);
			return new ResponseEntity<>(response,HttpStatus.GONE);
		}
		if(response.getContent()==null || response.getContent().isEmpty()) {
			response .setResponse_message(MagicUrlConstant.INVALID_URL);
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		response.setResponse_message(MagicUrlConstant.SUCCESS_FETCH_CONTENT);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@Override
	public boolean isUrlExpired(MagicUrl data) {
		// TODO Auto-generated method stub
		if(System.currentTimeMillis() >= Long.parseLong(data.getExpiry_timeStamp()))
			return true;
		return false;
	}

	@Override
	public FetchContentResponse retriveContentFromDB(String url) {
		// TODO Auto-generated method stub
		MagicUrl db_fetch = magicUrlRepo.findMagicUrlByShortUrl(url);
		FetchContentResponse db_response = new FetchContentResponse();
		if(db_fetch==null) {
		return db_response;	
		}
		if(isUrlExpired(db_fetch)) {
			db_response.setUrlExpired(true);
			return db_response;
		}
		db_response.setContent(db_fetch.getContent());
		db_response.setContent_type(db_fetch.getContent_type());
		Long expiryTime = Long.parseLong(db_fetch.getExpiry_timeStamp()) - System.currentTimeMillis();
		db_response.setExpiry_time(expiryTime);
		return db_response;
	}

}
