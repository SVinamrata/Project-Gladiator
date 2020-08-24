package com.lti.controller;

import java.util.List;
import com.lti.controller.Status.StatusType;
import com.lti.controller.StudentController.loginStatus;
import com.lti.dto.LoginDto;
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
	
	@PostMapping("/loginstudent")
	public loginStatus login(@RequestBody LoginDto loginDto){
		loginStatus loginStatus= new loginStatus();
		try {
			Student s=service.login(loginDto.getEmail(), loginDto.getPassword());
			loginStatus.setStudentId(s.getStudentID());
			loginStatus.setMessage("Login Successful");
			loginStatus.setStudentName(s.getStudentName());
			loginStatus.setStatus(StatusType.SUCCESS);
		} catch (StudentServiceException e) {
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
		}
		return loginStatus;
	}
	
	public static class loginStatus extends Status{
		private int studentId;
		private String studentName;
		
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
	}

	
	@PostMapping(path="/register")
	public Status addNewStudent(@RequestBody Student student) {
		System.out.println(student.getStudentEmail());
		System.out.println(student.getStudentPassword());
		try {
			
			service.addNewStudent(student);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			
			status.setMessage("Registeration Successful!");
			return status;
					
		}catch (StudentServiceException e) {
			// TODO: handle exception
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
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

	
	/*public List<Student> viewAllStudents() {
		return service.viewAllStudents();
	}*/
	
//	public List<Exam> viewAllExamsOfStudent(int studentId) {
//		return service.viewAllExamsOfStudent(studentId);
//	}
	
	

}
