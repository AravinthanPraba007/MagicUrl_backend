package com.project.magicurl.entity;

public class FetchContentResponse {

	String content;
	String content_type;
	Integer current_time;
	Integer expiry_time;
	String response_message;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public Integer getCurrent_time() {
		return current_time;
	}
	public void setCurrent_time(Integer current_time) {
		this.current_time = current_time;
	}
	public Integer getExpiry_time() {
		return expiry_time;
	}
	public void setExpiry_time(Integer expiry_time) {
		this.expiry_time = expiry_time;
	}
	public String getResponse_message() {
		return response_message;
	}
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}
	public FetchContentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
