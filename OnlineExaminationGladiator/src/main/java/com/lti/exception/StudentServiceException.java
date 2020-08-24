package com.lti.exception;

//right click->source->generate constructor from superclass

public class StudentServiceException extends RuntimeException {

	public StudentServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StudentServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
