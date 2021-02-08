package com.project.magicurl.service;

import com.project.magicurl.entity.GenerateUrlRequest;
import com.project.magicurl.entity.GenerateUrlResponse;

public interface GenerateUrlService {

	public GenerateUrlResponse createShortUrl(GenerateUrlRequest request);
	
	public boolean validLink(String url);
	
	public boolean userNameFound(String user_name);
	
	public String validContentType(String content_type);
	
	public String insertContentIntoDb(GenerateUrlRequest request);
	
}
