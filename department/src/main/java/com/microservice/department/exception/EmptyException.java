package com.microservice.department.exception;

public class EmptyException extends RuntimeException {

	private String errorcode;
	private String errorMessage;
	public EmptyException(String errorcode,String errorMessage){
		super();
		this.errorcode=errorcode;
		this.errorMessage=errorMessage;
	}
	public EmptyException(){
		
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
}
