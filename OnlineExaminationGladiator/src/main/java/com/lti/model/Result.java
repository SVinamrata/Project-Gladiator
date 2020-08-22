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

}
