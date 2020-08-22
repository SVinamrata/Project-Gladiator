package com.lti;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.lti.controller.SubjectController;
import com.lti.model.Subject;
import com.lti.repo.SubjectDao;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SubjectTest {
	
	@Autowired
	private SubjectDao subjectDao;

	@Test
	public void addNewSubjectTest() {
		Subject sub = new Subject();
		sub.setSubjectName("C#");
		System.out.println(subjectDao.addNewSubject(sub));
		
	}
	
	@Test
	public void viewAllSubjectsTest() {
		System.out.println(subjectDao.listSubjects());
	}

}
