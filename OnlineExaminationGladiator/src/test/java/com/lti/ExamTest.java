package com.lti;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.lti.controller.ExamController;
import com.lti.controller.StudentController;
import com.lti.controller.SubjectController;
import com.lti.model.Exam;
import com.lti.model.Student;
import com.lti.model.Subject;
import com.lti.repo.ExamDao;
import com.lti.repo.StudentDao;
import com.lti.repo.SubjectDao;

@SpringBootTest
//@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ExamTest {
	
	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private StudentDao studentDao;

	@Test
	public void addNewExamTest() {
		List<Exam> examList = new ArrayList<Exam>();
		Exam exam = new Exam();
		exam.setExamName("sql01");
		Subject sub = subjectDao.getSubjectBYSubjectId(22);
		exam.setTestSubject(sub);
		Student stu = studentDao.findAUser(20203);
		exam.setStudent(stu);
		examList.add(exam);	
		sub.setSubjectExams(examList);
		stu.setStudentExams(examList);
		System.out.println(examDao.addNewExam(exam));
	}
	
	@Test
	public void listExamsOfASubjectTest() {
		Subject sub = subjectDao.getSubjectBYSubjectId(22);
		System.out.println(examDao.listExamsOfASubject(sub));
	}
	
	@Test
	public void listAllExamsOfAStudentTest() {
		Student stu = studentDao.findAUser(20203);
		System.out.println(examDao.listAllExamsOfAStudent(stu));
	}

}
