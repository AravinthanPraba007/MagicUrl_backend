package com.project.magicurl.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Genrate Magic URL request")
public class GenerateUrlRequest {
	@ApiModelProperty(name = "Content",
			required = true, 
			notes = "Enter the content",
			example = "Hello this is a secret message")
	String content;
	@ApiModelProperty(name = "Content Type",
			required = true, 
			notes = "Enter the content type (link / message)",
			allowableValues = "link,message",
			example = "message")
	String content_type;
	@ApiModelProperty(hidden = true)
	String user_name;
	@ApiModelProperty(name = "Expiry Time",
			required = true, 
			notes = "Enter the expiry time(ms) allowed time range 1min to 1 day",
			allowableValues = "range[60000,86400000]",
			example = "600000")
	Integer expiry_time;
	
	String systemUrl;
	
	public String getSystemUrl() {
		return systemUrl;
	}
	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}
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
