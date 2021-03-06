package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.generateExamId;
import com.lti.model.Exam;
import com.lti.model.Student;
import com.lti.model.Subject;
import com.lti.service.ExamService;

@RestController
@CrossOrigin
public class ExamController {

	@Autowired
	ExamService service;

	@PostMapping("/examRegister")
	public int addNewExam(@RequestBody generateExamId generateExamId) {
		return service.addNewExam(generateExamId);
	}

	public List<Exam> listAllExams() {
		return service.listAllExams();
	}

	public List<Exam> listExamsOfASubject(Subject subject) {
		return service.listExamsOfASubject(subject);
	}

	public Exam findExamById(int examId) {
		return service.findExamById(examId);
	}

	public List<Exam> listAllExamsOfAStudent(Student student) {
		return service.listAllExamsOfAStudent(student);
	}

}
