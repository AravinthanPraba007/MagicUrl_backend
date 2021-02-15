package com.project.magicurl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.magicurl.constant.MagicUrlConstant;
import com.project.magicurl.entity.MagicUrl;
import com.project.magicurl.model.MagicUrlData;
import com.project.magicurl.model.RetriveMagicUrlsRequest;
import com.project.magicurl.model.RetriveMagicUrlsResponse;
import com.project.magicurl.repository.MagicUrlRepository;

@Service
public class FetchMagicurlsServiceImpl implements FetchMagicurlsService{
	
	@Autowired
	MagicUrlRepository magicRepo;
	
	@Autowired
	private Environment env;
	
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
			magicUrlsResponse.setData(dbResponse.getData());
			magicUrlsResponse.setResponse_message(MagicUrlConstant.MAGIC_URLS_RETRIVAL_SUCCESS);
		}
		return new ResponseEntity<>(magicUrlsResponse,HttpStatus.OK);
	}

	@Override
	public RetriveMagicUrlsResponse retriveMagicUrlsFromDb(String userName) {
		// TODO Auto-generated method stub
		RetriveMagicUrlsResponse response = new RetriveMagicUrlsResponse();
		List<MagicUrlData> response_dataList= new ArrayList<MagicUrlData>();
		response.setData(response_dataList);
		List<MagicUrl> db_response = magicRepo.findMagicUrlsByyUsername(userName);
		if(db_response==null || db_response.size()==0)
		return response;
		else {
			for(int idx = 0; idx<db_response.size(); idx++) {
				MagicUrl db_data = new MagicUrl();
				MagicUrlData response_data = new MagicUrlData();
				db_data = db_response.get(idx);
				if(db_data==null)
					continue;
				response_data.setMagicURL(env.getProperty("generate.baseurl")+db_data.getShortUrl());
				response_data.setContent(db_data.getContent());
				response_data.setContentType(db_data.getContent_type());
				response_data.setExpired(isLinkExpired(db_data));
				response.getData().add(response_data);
			}
		}
		return response;
	}
	
	public boolean isLinkExpired(MagicUrl data) {
		if(System.currentTimeMillis() >= Long.parseLong(data.getExpiry_timeStamp()))
			return true;
		return false;
	}

}
