package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result_gp")
public class Result {
	
	@Id
	@GeneratedValue
	@Column(name="USER_RESULT_ID")
	private int userResultId;
	
	@Column(name="RESULT_STATUS")
	private String resultStatus;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="LEVEL_PASSED")
	private int levelPassed;
	
	@OneToOne
	@JoinColumn(name="EXAM_ID") 
	private Exam examDetail;

	public int getUserResultId() {
		return userResultId;
	}

	public void setUserResultId(int userResultId) {
		this.userResultId = userResultId;
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

	public Exam getExamDetail() {
		return examDetail;
	}

	public void setExamDetail(Exam examDetail) {
		this.examDetail = examDetail;
	}

	@Override
	public String toString() {
		return "Result [userResultId=" + userResultId + ", resultStatus=" + resultStatus + ", score=" + score
				+ ", levelPassed=" + levelPassed + ", examDetail=" + examDetail.getExamId() + "]";
	}
	
	
	

}
