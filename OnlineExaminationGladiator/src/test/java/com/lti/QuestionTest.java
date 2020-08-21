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
		question.getQuestion();
		question.getChoiceOne();
		question.getChoiceTwo();
		question.getChoiceThree();
		question.getChoiceFour();
		question.getCorrectAns();
		
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
		question.getQuestionId();
		question.getQuestion();
		question.getChoiceOne();
		question.getChoiceTwo();
		question.getChoiceThree();
		question.getChoiceFour();
		question.getCorrectAns();
		
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
