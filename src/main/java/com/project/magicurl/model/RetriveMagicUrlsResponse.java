package com.project.magicurl.model;

import java.util.List;

public class RetriveMagicUrlsResponse {

	List<MagicUrlData> data;
	String response_message;
	
	public List<MagicUrlData> getData() {
		return data;
	}
	public void setData(List<MagicUrlData> data) {
		this.data = data;
	}
	public String getResponse_message() {
		return response_message;
	}
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}
	public RetriveMagicUrlsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RetriveMagicUrlsResponse [data=" + data + ", response_message=" + response_message + "]";
	}
	
	
}
