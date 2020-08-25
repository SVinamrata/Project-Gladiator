package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.exception.StudentServiceException;
import com.lti.model.Exam;
import com.lti.model.Student;
import com.lti.repo.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao dao;

	public void addNewStudent(Student student) {
		if(!dao.isStudentPresent(student.getStudentEmail()))
		{
			
			dao.addNewStudent(student);
		}
		else
			throw new StudentServiceException("Student already registered");
		
	}
	
	@Override
	public Student login(String studentEmail, String studentPassword) {
		try {
			int id= dao.findByEmailPassword(studentEmail, studentPassword);
			Student s= dao.findAUser(id);
			return s;
		}catch (EmptyResultDataAccessException e) {
			throw new StudentServiceException("Invalid Credentials");
		}
	}
	

	public boolean updateStudent(Student student) {
		return dao.updateStudent(student);
	}

	public boolean deleteStudent(int studentId) {
		return dao.deleteStudent(studentId);
	}

	public Student findAUser(int userId) {
		return dao.findAUser(userId);
	}


	public List<Student> viewAllStudents() {
		return dao.viewAllStudents();
	}


//	public List<Exam> viewAllExamsOfStudent(int studentId) {
//		return dao.viewAllExamsOfStudent(studentId);
//	}

}
