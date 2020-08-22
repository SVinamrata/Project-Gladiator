package com.lti;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.lti.controller.QuestionController;
import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.Subject;
import com.lti.repo.QuestionDao;
import com.lti.repo.SubjectDao;

@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

class QuestionTest {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Test
	public void addQuestion() {
		Question question=new Question();
		question.setQuestion("Which is use to find bugs in java programs ?");
		question.setLevel(1);
		question.setChoiceOne("JVM");
		question.setChoiceTwo("JRE");
		question.setChoiceThree("JDK");
		question.setChoiceFour("JDB");
		question.setCorrectAns("JDB");
		Subject subject = subjectDao.getSubjectBYSubjectId(64);
		question.setExamSubject(subject);
		List<Question> quesList = new ArrayList<Question>();
		quesList.add(question);
		subject.setSubjectQuestions(quesList);


		int id=questionDao.addQuestion(question);
		System.out.println("Question registered with id :"+id);
	}

	@Test
	public void deleteQuestion() {
		System.out.println(questionDao.deleteQuestion(20202));
	}
	@Test
	public void updateQuestion() {
		Question question=new Question();
		question.setQuestionId(71);
		question.setLevel(1);
		question.setQuestion("Which one is not a feature of java ?");
		question.setChoiceOne("Dynamic");
		question.setChoiceTwo("Architecture Neutral");
		question.setChoiceThree("Use of pointers");
		question.setChoiceFour("Object oriented");
		question.setCorrectAns("Use of pointers");
		Subject subject = subjectDao.getSubjectBYSubjectId(64);
		question.setExamSubject(subject);
		List<Question> quesList = new ArrayList<Question>();
		quesList.add(question);
		subject.setSubjectQuestions(quesList);

		
		questionDao.updateQuestion(question);
	}
	@Test
	public void listQuestions() {
		System.out.println(questionDao.listQuestions());
	}
	@Test
	public void getQuestionByQuestion_id() {
		System.out.println(questionDao.getQuestionByQuestion_id(20001));
	}
	@Test
	public void getQuestionsForASubject() {
		System.out.println(questionDao.getQuestionsForASubject(10001));
	}
}
