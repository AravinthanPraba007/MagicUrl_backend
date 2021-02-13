package com.project.magicurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.magicurl.constant.MagicUrlConstant;
import com.project.magicurl.entity.MagicUrl;
import com.project.magicurl.entity.User;
import com.project.magicurl.model.GenerateUrlRequest;
import com.project.magicurl.model.GenerateUrlResponse;
import com.project.magicurl.repository.MagicUrlRepository;
import com.project.magicurl.repository.UserDataRepository;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Base64;

@Service
public class GenerateUrlServiceImpl implements GenerateUrlService{
	
	@Autowired
	MagicUrlRepository magicUrlRepo;
	
	@Autowired
	UserDataRepository userRepo;
	
	@Autowired
	private Environment env;

	@Override
	public ResponseEntity<GenerateUrlResponse> createShortUrl(GenerateUrlRequest request) {
		GenerateUrlResponse response = new GenerateUrlResponse();
		String contentType = validContentType(request.getContent_type());
		if(MagicUrlConstant.CONTENT_ERROR.equals(contentType)) {
			response.setResponse_message(MagicUrlConstant.INVALID_CONTENT_TYPE_ERROR_MSG);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		if (MagicUrlConstant.CONTENT_LINK.equals(contentType)){
			if(!validLink(request.getContent())) {
				response.setResponse_message(MagicUrlConstant.INVALID_LINK_ERROR_MSG);
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}
		if(!validContent(request.getContent())) {
			response.setResponse_message(MagicUrlConstant.INVALID_CONTENT_ERROR_MSG);
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		if(request.getUser_name()!= null && !request.getUser_name().isEmpty()) {
			if(!userNameFound(request.getUser_name())) {
				response.setResponse_message(MagicUrlConstant.INVALID_USERNAME_ERROR_MSG);
				return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			}
		}
		
		String shortUrl = insertContentIntoDb(request);
		if(shortUrl.isEmpty()){
			response.setResponse_message(MagicUrlConstant.GENERATE_URL_ERROR_MSG);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setShortUrl(shortUrl);
		response.setResponse_message(MagicUrlConstant.SUCCESS_GENRATE_URL_MSG);	
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@Override
	public boolean validLink(String url) {
		/**
		 * Using Regular Expression provided by OWASP 
		 * https://raw.githubusercontent.com/ESAPI/esapi-java-legacy/develop/configuration/esapi/validation.properties
		 */

		final String URL_REGEX =
	            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
	            "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
	            "([).!';/?:,][[:blank:]])?$";
		final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
		
		if(url!=null && !url.isEmpty()) {
			Matcher matcher = URL_PATTERN.matcher(url);
	        return matcher.matches();
		}
		else
		return true;
	}

	@Override
	public boolean userNameFound(String user_name) {
		//Need to check for user name in DB
		User db_data = userRepo.findByUserName(user_name);
		if(db_data != null && db_data.getUser_name()!=null && db_data.getUser_name().equals(user_name))
			return true;
		return false;
	}

	@Override
	public String validContentType(String content_type) {
		//CHECK the content type , for now system allow only "LINK" , "MESSAGE"
		if((MagicUrlConstant.CONTENT_LINK).equals(content_type.toUpperCase()))
			return MagicUrlConstant.CONTENT_LINK;
		if((MagicUrlConstant.CONTENT_MESSAGE).equals(content_type.toUpperCase()))
			return MagicUrlConstant.CONTENT_MESSAGE;
		else
			return MagicUrlConstant.CONTENT_ERROR;
	}

	@Override
	public String insertContentIntoDb(GenerateUrlRequest request) {
		/**
		 * Need to implement the data base connection and insert data
		 */
		MagicUrl dbData = new MagicUrl();
		String shortUrl = generateUniqueID();
		dbData.setContent_type(request.getContent_type());
		dbData.setContent(request.getContent());
		dbData.setExpiry_time(request.getExpiry_time());
		dbData.setShortUrl(shortUrl);
		Long currentTime = System.currentTimeMillis();
		dbData.setCreated_timeStamp(String.valueOf(currentTime));
		dbData.setExpiry_timeStamp(String.valueOf(currentTime+request.getExpiry_time()));
		MagicUrl dbResponse = magicUrlRepo.save(dbData);
		return (env.getProperty("generate.baseurl")+dbResponse.getShortUrl());
	}

	@Override
	public String generateUniqueID() {
		/**
		 * Need to generate unique id ,currently using UUID and base64 encoding
		 */
		String uuid_value = UUID.randomUUID().toString().substring(0,6).replace("-", "");
		String id = Base64.getEncoder().encodeToString(uuid_value.getBytes());
		return id;
	}

	@Override
	public boolean validContent(String content) {
		// TODO Auto-generated method stub
		String trim_content = content.trim();
		if(trim_content==null || trim_content.isEmpty())
			return false;
		else
			return true;
	}

	
}
