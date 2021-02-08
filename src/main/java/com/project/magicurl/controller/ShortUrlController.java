package com.project.magicurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.magicurl.entity.GenerateUrlRequest;
import com.project.magicurl.entity.GenerateUrlResponse;
import com.project.magicurl.service.GenerateUrlService;

@RestController
public class ShortUrlController {
	
	@Autowired
	GenerateUrlService generateUrlService;
	

	@PostMapping("/submit")
	public ResponseEntity<GenerateUrlResponse> generateUrl(@RequestBody GenerateUrlRequest request){
		return generateUrlService.createShortUrl(request);
	}
	
	@GetMapping("/fetch/{url}")
	public ResponseEntity<String> fetchContentByUrl(@PathVariable String urlRequest){
		
		return null;
	}

}
