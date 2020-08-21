package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Exam;
import com.lti.model.Student;
import com.lti.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService service;
	
	public int addNewStudent(Student student) {
		return service.addNewStudent(student);
	}

	public boolean updateStudent(Student student) {
		return service.updateStudent(student);
	}

	public boolean deleteStudent(int studentId) {
		return service.deleteStudent(studentId);
	}

	public Student findAUser(int userId) {
		return service.findAUser(userId);
	}

	public boolean loginStudent(int userId, String password) {
		return service.loginStudent(userId, password);
	}
	
	public List<Student> viewAllStudents() {
		return service.viewAllStudents();
	}
	
//	public List<Exam> viewAllExamsOfStudent(int studentId) {
//		return service.viewAllExamsOfStudent(studentId);
//	}
	
	

}
