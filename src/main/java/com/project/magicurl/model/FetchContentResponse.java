package com.project.magicurl.model;

public class FetchContentResponse {

	String content;
	String content_type;
	Long current_time;
	Long expiry_time;
	boolean urlExpired;
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
	public Long getCurrent_time() {
		return current_time;
	}
	public void setCurrent_time(Long current_time) {
		this.current_time = current_time;
	}
	public Long getExpiry_time() {
		return expiry_time;
	}
	public void setExpiry_time(Long expiry_time) {
		this.expiry_time = expiry_time;
	}
	public String getResponse_message() {
		return response_message;
	}
	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}
	
	public boolean isUrlExpired() {
		return urlExpired;
	}
	public void setUrlExpired(boolean urlExpired) {
		this.urlExpired = urlExpired;
	}
	public FetchContentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
