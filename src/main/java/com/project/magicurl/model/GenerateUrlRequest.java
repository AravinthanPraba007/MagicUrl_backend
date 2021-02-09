package com.project.magicurl.model;


public class GenerateUrlRequest {

	String content;
	String content_type;
	String user_name;
	Integer expiry_time;
	public GenerateUrlRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getExpiry_time() {
		return expiry_time;
	}
	public void setExpiry_time(Integer expiry_time) {
		this.expiry_time = expiry_time;
	}
	
	
}
