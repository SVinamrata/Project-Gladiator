package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.lti.controller.StudentController;
import com.lti.model.Student;
import com.lti.repo.StudentDao;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudentTest {

	@Autowired
	private StudentDao studentDao;

	@Test
	public void addNewStudentTest() {
		Student stud = new Student();

		stud.setStudentName("Sheldon Cooper1");
		stud.setStudentPassword("buzzinga1");
		stud.setStudentDOB(LocalDate.of(1998, 02, 15));
		stud.setStudentEmail("cooper.sheldon1@gmail.com");
		stud.setStudentCity("Pasadena1");
		stud.setStudentState("California1");

		stud.setStudentYOC(2018);
		stud.setStudentMobile("1238452");
		
		int i = studentDao.addNewStudent(stud);
		System.out.println("Student Successfully registered, ID - "+i);
	}
	
	@Test
	public void deleteStudentTest() {
		System.out.println(studentDao.deleteStudent(20202));
	}
	
	@Test
	public void findAUserTest() {
		System.out.println(studentDao.findAUser(20227));
	}
	
	@Test
	public void fetchByEmailAndPassword() {  // EmptyResultDataAccessException
		long id=studentDao.findByEmailPassword("varun@lti.com", "123");
		System.out.println(id);
	}
	
	@Test
	public void updateStudentTest() {
		Student stud = new Student();
		stud.setStudentID(20203);
		stud.setStudentName("Sheldon Cooper");
		stud.setStudentPassword("starWars");
		stud.setStudentDOB(LocalDate.of(1988, 02, 15));
		stud.setStudentEmail("cooper.sheldon@gmail.com");
		stud.setStudentCity("Pasadena");
		stud.setStudentState("California");
		stud.setStudentYOC(2018);
		stud.setStudentMobile("99889");
		
		System.out.println(studentDao.updateStudent(stud));
	}
	
	@Test
	public void viewAllStudentsTest() {
		System.out.println(studentDao.viewAllStudents());
	}
	
	@Test
	public void listStudentsBySubject() {
		System.out.println(studentDao.listStudentsBySubjectId(44));
	}
	
//	@Test
//	public void viewAllExamsOfStudentTest() {
//		System.out.println(controller.viewAllExamsOfStudent(20203));
//	}

}
