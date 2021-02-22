package com.project.magicurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@Api(tags = "Magic Url Core Controller" )
public class ShortUrlController {
	
	@Autowired
	GenerateUrlService generateUrlService;
	
	@Autowired
	FetchContentService fetchContentService;
	
	@ApiOperation(value = "To create Magic Url for the given content",
			produces = "application/json", 
			consumes = "application/json",
			httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully Magic URL created"),
            @ApiResponse(code = 400, message = "Bad request , please check the request parameter values"),
            @ApiResponse(code = 500, message = "Internal System Error")
	})
	@PostMapping("/submit")
	public ResponseEntity<GenerateUrlResponse> generateUrl(@ApiParam(name = "Generate URL request",
			value = "Enter the Content , Content Type(message/link), Expiry time in milliseconds")
		@RequestBody GenerateUrlRequest request){
		return generateUrlService.createShortUrl(request);
	}
	
	@ApiOperation(value = "To fetch content for the given magic URL",
			produces = "application/json", 
			httpMethod = "GET")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully content fetched"),
			@ApiResponse(code = 204, message = "Given Magic URL doen't exist"),
            @ApiResponse(code = 400, message = "Bad request , please check the request parameter values"),
            @ApiResponse(code = 500, message = "Internal System Error")
	})
	@GetMapping("/fetch/{urlRequest}")
	public ResponseEntity<FetchContentResponse> fetchContentByUrl(@ApiParam(
		value = "Enter the generated unique ID present at last of Magic Url" ,
		example="MGJmMDk1") 
		@PathVariable String urlRequest){
		return fetchContentService.fetchContent(urlRequest);
	}

}
