package com.project.magicurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.magicurl.model.RetriveMagicUrlsRequest;
import com.project.magicurl.model.RetriveMagicUrlsResponse;
import com.project.magicurl.service.FetchMagicurlsService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@CrossOrigin(origins = "*")
@RestController
public class UserMagicurlController {
	
	@Autowired
	FetchMagicurlsService fetchMagicurlsService;

	@GetMapping("/magicUrls")
	public ResponseEntity<RetriveMagicUrlsResponse> fetchMagicUrls(@RequestBody RetriveMagicUrlsRequest request) {
		return fetchMagicurlsService.retriveMagicUrls(request);
	}
}
