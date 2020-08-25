package com.lti.controller;


public class Status{
	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private StatusType status;
	private String message;
	
	public static enum StatusType{
		SUCCESS, FAILURE;
	}
}