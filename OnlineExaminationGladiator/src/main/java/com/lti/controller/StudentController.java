package com.lti.controller;

import java.util.List;
import com.lti.controller.Status.StatusType;
import com.lti.exception.StudentServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Exam;
import com.lti.model.Student;
import com.lti.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/view")
	public List<Student> viewAllStudents() {
		return service.viewAllStudents();
	}
	
	@PostMapping(path="/register")
	public Status addNewStudent(@RequestBody Student student) {
		System.out.println(student.getStudentEmail());
		System.out.println(student.getStudentPassword());
		try {
			
			service.addNewStudent(student);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			
			status.setMesaage("Registeration Successful!");
			return status;
					
		}catch (StudentServiceException e) {
			// TODO: handle exception
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMesaage(e.getMessage());
			return status;
		}
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
	
	/*public List<Student> viewAllStudents() {
		return service.viewAllStudents();
	}*/
	
//	public List<Exam> viewAllExamsOfStudent(int studentId) {
//		return service.viewAllExamsOfStudent(studentId);
//	}
	
	

}
