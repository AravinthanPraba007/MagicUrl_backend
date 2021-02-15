package com.project.magicurl.model;

public class MagicUrlData {
	
	String MagicURL;
	String contentType;
	String content;
	boolean isExpired;
	public String getMagicURL() {
		return MagicURL;
	}
	public void setMagicURL(String magicURL) {
		MagicURL = magicURL;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	public MagicUrlData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "MagicUrlData [MagicURL=" + MagicURL + ", contentType=" + contentType + ", content=" + content
				+ ", isExpired=" + isExpired + "]";
	}
	

}
