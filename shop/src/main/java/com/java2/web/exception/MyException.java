package com.java2.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND ,reason="hahaha")
public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String statusCode;
	private String messageDescription;
	
	public MyException(){
		super();
	}
	
	public MyException(String messageDescription){
		super(messageDescription);
		this.messageDescription = messageDescription;
	}
	
	public MyException(String statusCode, String messageDescription) {
		super();
		this.statusCode = statusCode;
		this.messageDescription = messageDescription;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessageDescription() {
		return messageDescription;
	}
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}
	
}
