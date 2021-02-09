package com.project.magicurl.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.magicurl.model.RetriveMagicUrlsRequest;
import com.project.magicurl.model.RetriveMagicUrlsResponse;

@Service
public class FetchMagicurlsServiceImpl implements FetchMagicurlsService{

	@Override
	public ResponseEntity<RetriveMagicUrlsResponse> retriveMagicUrls(RetriveMagicUrlsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RetriveMagicUrlsResponse retriveMagicUrlsFromDb(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
