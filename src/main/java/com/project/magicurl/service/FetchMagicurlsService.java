package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;

import com.project.magicurl.model.RetriveMagicUrlsRequest;
import com.project.magicurl.model.RetriveMagicUrlsResponse;

public interface FetchMagicurlsService {

	public ResponseEntity<RetriveMagicUrlsResponse> retriveMagicUrls(RetriveMagicUrlsRequest request);
	
	public RetriveMagicUrlsResponse retriveMagicUrlsFromDb (String userName);
}
