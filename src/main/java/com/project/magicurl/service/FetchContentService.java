package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;

import com.project.magicurl.entity.FetchContentResponse;

public interface FetchContentService {

	public ResponseEntity<FetchContentResponse> fetchContent(String url);
	
	public boolean isURLprsent(String url);
	
	public boolean isContentExpired(Integer expiryTime);
	
	public FetchContentResponse retriveContentFromDB(String url);
}
