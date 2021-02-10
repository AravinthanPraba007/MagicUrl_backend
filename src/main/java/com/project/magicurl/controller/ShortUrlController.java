package com.project.magicurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.magicurl.model.FetchContentResponse;
import com.project.magicurl.model.GenerateUrlRequest;
import com.project.magicurl.model.GenerateUrlResponse;
import com.project.magicurl.service.FetchContentService;
import com.project.magicurl.service.GenerateUrlService;

@RestController
public class ShortUrlController {
	
	@Autowired
	GenerateUrlService generateUrlService;
	
	@Autowired
	FetchContentService fetchContentService;

	@PostMapping("/submit")
	public ResponseEntity<GenerateUrlResponse> generateUrl(@RequestBody GenerateUrlRequest request){
		return generateUrlService.createShortUrl(request);
	}
	
	@GetMapping("/fetch/{urlRequest}")
	public ResponseEntity<FetchContentResponse> fetchContentByUrl(@PathVariable String urlRequest){
		return fetchContentService.fetchContent(urlRequest);
	}

}
