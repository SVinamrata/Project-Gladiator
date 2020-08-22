package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject_gp")
@NamedQuery(name = "fetch-all",query = "select sub from Subject sub order by sub.subjectId")
public class Subject {
	
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}

	@Id
	@GeneratedValue
	@Column(name="SUBJECT_ID")
	private int subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	@OneToMany(mappedBy="examSubject" ,cascade=CascadeType.ALL)
	private List<Exam> subjectExams;
	
	@OneToMany(mappedBy="questionSubject" ,cascade=CascadeType.ALL)
	private List<Question> subjectQuestions;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<Exam> getSubjectExams() {
		return subjectExams;
	}

	public void setSubjectExams(List<Exam> subjectExams) {
		this.subjectExams = subjectExams;
	}

	public List<Question> getSubjectQuestions() {
		return subjectQuestions;
	}

	public void setSubjectQuestions(List<Question> subjectQuestions) {
		this.subjectQuestions = subjectQuestions;
	}

}
