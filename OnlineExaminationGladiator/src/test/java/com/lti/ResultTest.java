package com.lti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.model.Exam;
import com.lti.model.Result;
import com.lti.model.Student;
import com.lti.model.Subject;
import com.lti.repo.ExamDao;
import com.lti.repo.ResultDao;
import com.lti.repo.StudentDao;
import com.lti.repo.SubjectDao;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ResultTest {
	
	@Autowired
	ResultDao resultDao;
	
	@Autowired
	ExamDao examDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	SubjectDao subjectDao;

	@Test
	void addResultTest() {
		Result result = new Result();
		result.setResultStatus("Passed");
		result.setScore(70);
		result.setLevelPassed(1);
		Exam exam = examDao.findExamById(72);
		result.setExamDetail(exam);
		exam.setTestResult(result);
		
		System.out.println(resultDao.addResult(result));
		
	}
	
	@Test
	void getResultsOfaStudentTest() {
		Student student = studentDao.findAUser(20227);
		System.out.println(resultDao.getResultsOfaStudent(student));
	}
	
	@Test
	void levelFetchTest() {
		Student student = studentDao.findAUser(20227);
		Subject subject = subjectDao.getSubjectBYSubjectId(44);
		System.out.println(resultDao.fetchLevelOfStudent(student, subject)); 
	}

}
