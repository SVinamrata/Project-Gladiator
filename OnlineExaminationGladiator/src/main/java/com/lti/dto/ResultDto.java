package com.lti.dto;

import javax.persistence.Column;

public class ResultDto {
	
	private int userResultId;
	
	private int examId;
	
	private String examSubject;
	
	private String resultStatus;
	
	private int score;
	
	private int levelPassed;


	public int getUserResultId() {
		return userResultId;
	}

	public void setUserResultId(int userResultId) {
		this.userResultId = userResultId;
	}
	
	

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamSubject() {
		return examSubject;
	}

	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevelPassed() {
		return levelPassed;
	}

	public void setLevelPassed(int levelPassed) {
		this.levelPassed = levelPassed;
	}
	
	
	
	
	

}
