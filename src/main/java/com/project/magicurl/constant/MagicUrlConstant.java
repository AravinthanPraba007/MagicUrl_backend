package com.project.magicurl.constant;

public class MagicUrlConstant {
	
	public static final String INVALID_REQUEST = "Invalid request";

	public static final String CONTENT_MESSAGE = "MESSAGE";
	public static final String CONTENT_LINK = "LINK";
	public static final String CONTENT_ERROR = "ERROR";
	public static final String INVALID_CONTENT_ERROR_MSG = "Invalid content passed, Content cannot be null or empty";
	public static final String INVALID_EXPIRYTIME_ERROR_MSG = "Expiry time cannot be empty or less than One minute or greater than one hour";
	public static final String INVALID_CONTENT_TYPE_ERROR_MSG = "Invalid content Type passed , Pass content type as link or message";
	public static final String INVALID_LINK_ERROR_MSG = "Invalid link passed , Pass valid link";
	public static final String INVALID_USERNAME_ERROR_MSG = "Invalid username passed , Pass valid username";
	public static final String GENERATE_URL_ERROR_MSG = "Unable to generate short url ,Please try again later. Facing internal error / DB connection issue";
	public static final String SUCCESS_GENRATE_URL_MSG = "Short url successfully Created";
	public static final String VALID_EXPIRYTIME ="Valid expiry time";
	
	
//	Fetch Content Constants
	public static final String SUCCESS_FETCH_CONTENT = "Content fetched successfully for the provided url";
	public static final String INVALID_URL = "Provided URL is invalid";
	public static final String EXPIRED_URL = "URL Expired";
	public static final String FETCH_CONTENT_ERROR_MSG = "Unable to fetch the content, Please try again later. Facing internal error/ DB connection issue";
	
	
//	User registerartion/signin Constants
	public static final String USERNAME_NOT_AVAILABALE = "USername already taken , try another username";
	public static final String SUCCESS_USER_REGISTERED = "Account created successfully";
	public static final String USER_REGISTRATION_ERROR_MSG = "Unable to crate account , please try again later, Facing internal error/ db connection issue";

	public static final String PASSWORD_INVALID = "Incorrect Password";
	public static final String USERNAME_INVALID = "User name not found";
	public static final String SIGN_IN_SUCESS_MSG = "SignIn Successfull";
	public static final String USER_SIGN_IN_ERROR_MSG = "Unable to signIn , please try again later, Facing internal error/ db connection issue";
	
//	Fetching Magic urls constants
	public static final String USERNAME_EMPTY = "UserName cant be empty";
	public static final String NO_MAGICURL_FOUND = "No Magic urls found";
	public static final String MAGIC_URLS_RETRIVAL_SUCCESS = "Retrived magic Urls successfully";
	
}
