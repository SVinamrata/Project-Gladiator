package com.lti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.lti.controller.QuestionController;
import com.lti.model.Question;
import com.lti.repo.QuestionDao;

@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

class QuestionTest {

	@Autowired
	private QuestionDao dao;
	
	@Test
	public void addQuestion() {
		Question question=new Question();
		question.setQuestion("Which is use to find bugs in java programs ?");
		question.setChoiceOne("JVM");
		question.setChoiceTwo("JRE");
		question.setChoiceThree("JDK");
		question.setChoiceFour("JDB");
		question.setCorrectAns("JDB");
		
		int id=dao.addQuestion(question);
		System.out.println("Question registered with id :"+id);
	}

	@Test
	public void deleteQuestion() {
		System.out.println(dao.deleteQuestion(20202));
	}
	@Test
	public void updateQuestion() {
		Question question=new Question();
		question.setQuestionId(41);
		question.setLevel(1);
		question.setQuestion("Which one is not a feature of java ?");
		question.setChoiceOne("Dynamic");
		question.setChoiceTwo("Architecture Neutral");
		question.setChoiceThree("Use of pointers");
		question.setChoiceFour("Object oriented");
		question.setCorrectAns("Use of pointers");
		
		dao.updateQuestion(question);
	}
	@Test
	public void listQuestions() {
		System.out.println(dao.listQuestions());
	}
	@Test
	public void getQuestionByQuestion_id() {
		System.out.println(dao.getQuestionByQuestion_id(20001));
	}
	@Test
	public void getQuestionsForASubject() {
		System.out.println(dao.getQuestionsForASubject(10001));
	}
}
