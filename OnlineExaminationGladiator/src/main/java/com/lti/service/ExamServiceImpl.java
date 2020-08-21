package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.Student;
import com.lti.model.Subject;
import com.lti.repo.ExamDao;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	ExamDao dao;

	public int addNewExam(Exam exam) {
		return dao.addNewExam(exam);
	}

	public List<Exam> listAllExams() {
		return dao.listAllExams();
	}

	public List<Exam> listExamsOfASubject(Subject subject) {
		return dao.listExamsOfASubject(subject);
	}

	public Exam findExamById(int examId) {
		return dao.findExamById(examId);
	}

	public List<Exam> listAllExamsOfAStudent(Student student) {
		return dao.listAllExamsOfAStudent(student);
	}


}
