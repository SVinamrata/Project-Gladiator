package com.lti.service;

import java.util.List;

import com.lti.model.Subject;

public interface SubjectService {
	public int addNewSubject(Subject subject);
	public boolean updateSubject(Subject subject);
	public boolean deleteSubject(int subjectId);
	public Subject getSubjectBYSubjectId(int subjectId);
	public List<Subject> listSubjects();
	

}
