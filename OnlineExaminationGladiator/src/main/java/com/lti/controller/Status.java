package com.lti.controller;


public class Status{
	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public String getMesaage() {
		return mesaage;
	}

	public void setMesaage(String mesaage) {
		this.mesaage = mesaage;
	}

	private StatusType status;
	private String mesaage;
	
	public static enum StatusType{
		SUCCESS, FAILURE;
	}
}