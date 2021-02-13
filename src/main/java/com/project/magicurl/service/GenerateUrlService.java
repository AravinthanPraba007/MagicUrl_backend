package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;

import com.project.magicurl.model.GenerateUrlRequest;
import com.project.magicurl.model.GenerateUrlResponse;

public interface GenerateUrlService {

	public ResponseEntity<GenerateUrlResponse> createShortUrl(GenerateUrlRequest request);
	
	public boolean validLink(String url);
	
	public boolean validContent(String content);
	
	public boolean userNameFound(String user_name);
	
	public String validContentType(String content_type);
	
	public String insertContentIntoDb(GenerateUrlRequest request);
	
	public String generateUniqueID();
	
	public String validExpiryTime(Integer expiryTime);
	
}
