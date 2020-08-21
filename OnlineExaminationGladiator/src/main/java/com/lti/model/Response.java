package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "response_gp")
public class Response {
	
	
	@Id
	@GeneratedValue
	@Column(name="CURRENT_RESPONSE_ID")
	private int currentResponseId;
	
	@Column(name="RESPONSE_STATUS")
	private String responseStatus;
	
	@Column(name="USER_RESPONSE")
	private String studentResponse;
	
	@ManyToOne
	@JoinColumn(name="TEST_ID")
	private Exam examDetails;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private Question question;

}
