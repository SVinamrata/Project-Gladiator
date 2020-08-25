package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question_gp")
public class Question {
	
	@Id
	@GeneratedValue
	@Column(name="QUESTION_ID")
	private int questionId;
	
	@Column(name="QUESTION_LEVEL")
	private int level;
	
	@Column(name="QUESTION")
	private String question;
		
	@Column(name="OPTION1")
	private String choiceOne;
	
	@Column(name="OPTION2")
	private String choiceTwo;
	
	@Column(name="OPTION3")
	private String choiceThree;
	
	@Column(name="OPTION4")
	private String choiceFour;
	
	@Column(name="CORRECT_ANS")
	private String correctAns;
	
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private Subject questionSubject;
	

	@OneToMany(mappedBy="question" ,cascade=CascadeType.ALL)
	private List<Response> responseList;


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public Subject getQuestionSubject() {
		return questionSubject;
	}


	public void setQuestionSubject(Subject questionSubject) {
		this.questionSubject = questionSubject;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getChoiceOne() {
		return choiceOne;
	}


	public void setChoiceOne(String choiceOne) {
		this.choiceOne = choiceOne;
	}


	public String getChoiceTwo() {
		return choiceTwo;
	}


	public void setChoiceTwo(String choiceTwo) {
		this.choiceTwo = choiceTwo;
	}


	public String getChoiceThree() {
		return choiceThree;
	}


	public void setChoiceThree(String choiceThree) {
		this.choiceThree = choiceThree;
	}


	public String getChoiceFour() {
		return choiceFour;
	}


	public void setChoiceFour(String choiceFour) {
		this.choiceFour = choiceFour;
	}


	public String getCorrectAns() {
		return correctAns;
	}


	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}



	public Subject getExamSubject() {
		return questionSubject;
	}


	public void setExamSubject(Subject examSubject) {
		this.questionSubject = examSubject;
	}


	public List<Response> getResponseList() {
		return responseList;
	}


	public void setResponseList(List<Response> responseList) {
		this.responseList = responseList;
	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", level=" + level + ", question=" + question + ", choiceOne="
				+ choiceOne + ", choiceTwo=" + choiceTwo + ", choiceThree=" + choiceThree + ", choiceFour=" + choiceFour
				+ ", correctAns=" + correctAns + "]";
	}
	
	
	

}
