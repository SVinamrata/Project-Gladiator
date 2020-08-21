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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_gp")
public class Exam {
	
	@Id
	@GeneratedValue
	@Column(name="EXAM_ID")
	private int examId;
	
	@Column(name = "EXAM_NAME")
	private String examName;
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private Subject examSubject;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@OneToMany(mappedBy="examDetails" ,cascade=CascadeType.ALL)
	private List<Response> responses;
	
	@OneToOne(mappedBy="examDetail",cascade = CascadeType.ALL)
	private Result examResult;

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Subject getTestSubject() {
		return examSubject;
	}

	public void setTestSubject(Subject testSubject) {
		this.examSubject = testSubject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Result getTestResult() {
		return examResult;
	}

	public void setTestResult(Result testResult) {
		this.examResult = testResult;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + "]";
	}
	
	
	

}
