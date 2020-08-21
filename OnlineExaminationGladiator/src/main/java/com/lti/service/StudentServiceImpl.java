package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Exam;
import com.lti.model.Student;
import com.lti.repo.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao dao;

	public int addNewStudent(Student student) {
		return dao.addNewStudent(student);
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

	public boolean loginStudent(int userId, String password) {
		return dao.loginStudent(userId, password);
	}

	public List<Student> viewAllStudents() {
		return dao.viewAllStudents();
	}

//	public List<Exam> viewAllExamsOfStudent(int studentId) {
//		return dao.viewAllExamsOfStudent(studentId);
//	}

}
