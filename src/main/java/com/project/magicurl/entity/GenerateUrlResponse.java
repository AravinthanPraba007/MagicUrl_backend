package com.project.magicurl.entity;

import org.springframework.stereotype.Component;

@Component
public class GenerateUrlResponse {
	
	private String shortUrl;
	private String response_message;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getResponse_message() {
		return response_message;
	}

	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}

	public GenerateUrlResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
