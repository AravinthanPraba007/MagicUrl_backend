package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;

import com.project.magicurl.entity.FetchContentResponse;

public class FetchContentServiceImpl implements FetchContentService{

	@Override
	public ResponseEntity<FetchContentResponse> fetchContent(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isURLprsent(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isContentExpired(String expiryTime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FetchContentResponse retriveContentFromDB(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
