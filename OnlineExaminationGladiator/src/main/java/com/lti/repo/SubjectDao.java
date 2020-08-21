package com.lti.repo;

import java.util.List;

import com.lti.model.Subject;

public interface SubjectDao {
	public int addNewSubject(Subject subject);
	public boolean updateSubject(Subject subject);
	public boolean deleteSubject(int subjectId);
	public Subject getSubjectBYSubjectId(int subjectId);
	public List<Subject> listSubjects();

}
