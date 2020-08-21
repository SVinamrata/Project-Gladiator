package com.lti.repo;

import java.util.List;

import com.lti.model.Exam;
import com.lti.model.Student;
import com.lti.model.Subject;

public interface ExamDao {
	
	int addNewExam(Exam exam);
	List<Exam> listAllExams();
	List<Exam> listExamsOfASubject(Subject subject);
	Exam findExamById(int examId);
	List<Exam> listAllExamsOfAStudent(Student student);
	

}
