package com.project.magicurl.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("magic_url")
public class MagicUrl {

	@Id
	private String id;
	private String shortUrl;
	private String content;
	private String content_type;
	private String user_name;
	private String created_timeStamp;
	private String expiry_timeStamp;
	private Integer expiry_time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
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
	public String getCreated_timeStamp() {
		return created_timeStamp;
	}
	public void setCreated_timeStamp(String created_timeStamp) {
		this.created_timeStamp = created_timeStamp;
	}
	public String getExpiry_timeStamp() {
		return expiry_timeStamp;
	}
	public void setExpiry_timeStamp(String expiry_timeStamp) {
		this.expiry_timeStamp = expiry_timeStamp;
	}
	public Integer getExpiry_time() {
		return expiry_time;
	}
	public void setExpiry_time(Integer expiry_time) {
		this.expiry_time = expiry_time;
	}
	public MagicUrl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
