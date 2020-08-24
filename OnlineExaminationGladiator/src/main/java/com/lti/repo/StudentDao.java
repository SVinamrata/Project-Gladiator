package com.lti.repo;

import java.util.List;

import com.lti.model.Exam;
import com.lti.model.Student;


public interface StudentDao {
	int addNewStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(int studentId);
	Student findAUser(int userId);
	List<Student> viewAllStudents();
//	List<Exam> viewAllExamsOfStudent(int studentId);
	int findByEmailPassword(String studentEmail, String studentPassword);
	boolean isStudentPresent(String studentEmail);


}
