package com.lti.dto;

public class ResponseDto {
    private String responseStatus;
    private String studentResponse;
    private int examId;
    private int questionId;
    
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getStudentResponse() {
		return studentResponse;
	}
	public void setStudentResponse(String studentResponse) {
		this.studentResponse = studentResponse;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
    
    

}
