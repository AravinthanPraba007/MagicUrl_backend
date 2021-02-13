package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;

import com.project.magicurl.entity.MagicUrl;
import com.project.magicurl.model.FetchContentResponse;

public interface FetchContentService {

	public ResponseEntity<FetchContentResponse> fetchContent(String url);
	
	public boolean isUrlExpired(MagicUrl data);
	
	public FetchContentResponse retriveContentFromDB(String url);
}
