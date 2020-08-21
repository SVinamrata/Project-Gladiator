package com.lti.repo;

import java.util.List;

import com.lti.model.Exam;
import com.lti.model.Student;


public interface StudentDao {
	int addNewStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(int studentId);
	Student findAUser(int userId);
	boolean loginStudent(int userId , String password);
	List<Student> viewAllStudents();
//	List<Exam> viewAllExamsOfStudent(int studentId);


}
