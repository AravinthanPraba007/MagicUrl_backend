package com.project.magicurl.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.magicurl.constant.MagicUrlConstant;
import com.project.magicurl.model.RetriveMagicUrlsRequest;
import com.project.magicurl.model.RetriveMagicUrlsResponse;

@Service
public class FetchMagicurlsServiceImpl implements FetchMagicurlsService{

	@Override
	public ResponseEntity<RetriveMagicUrlsResponse> retriveMagicUrls(RetriveMagicUrlsRequest request) {
		// TODO Auto-generated method stub
		RetriveMagicUrlsResponse magicUrlsResponse = new RetriveMagicUrlsResponse();
		if(request.getUsername()==null || request.getUsername().isEmpty() ) {
			magicUrlsResponse.setResponse_message(MagicUrlConstant.USERNAME_EMPTY);
			return new ResponseEntity<>(magicUrlsResponse,HttpStatus.BAD_REQUEST);
		}
		RetriveMagicUrlsResponse dbResponse = retriveMagicUrlsFromDb(request.getUsername());
		if(dbResponse==null || dbResponse.getData()==null) {
			magicUrlsResponse.setResponse_message(MagicUrlConstant.NO_MAGICURL_FOUND);
			return new ResponseEntity<>(magicUrlsResponse,HttpStatus.NO_CONTENT);
		}
		else {
			magicUrlsResponse.setResponse_message(MagicUrlConstant.MAGIC_URLS_RETRIVAL_SUCCESS);
		}
		return new ResponseEntity<>(magicUrlsResponse,HttpStatus.OK);
	}

	@Override
	public RetriveMagicUrlsResponse retriveMagicUrlsFromDb(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
