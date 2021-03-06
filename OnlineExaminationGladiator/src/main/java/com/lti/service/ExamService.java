package com.lti.service;

import java.util.List;

import com.lti.dto.generateExamId;
import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.Student;
import com.lti.model.Subject;

public interface ExamService {
	
	int addNewExam(generateExamId generateExamId);
	List<Exam> listAllExams();
	List<Exam> listExamsOfASubject(Subject subject);
	Exam findExamById(int examId);
	List<Exam> listAllExamsOfAStudent(Student student);

}
