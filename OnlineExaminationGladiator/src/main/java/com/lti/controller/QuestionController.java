package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Question;
import com.lti.service.QuestionService;

@RestController
@CrossOrigin
public class QuestionController {

	@Autowired
	QuestionService service;

	public List<Question> listQuestions() {
		return service.listQuestions();
	}

	public boolean deleteQuestion(int questionId) {
		return service.deleteQuestion(questionId);
	}

	public boolean updateQuestion(Question question) {
		return service.updateQuestion(question);
	}

	public Question getQuestionByQuestion_id(int questionId) {
		return service.getQuestionByQuestion_id(questionId);
	}

	public int addQuestion(Question question) {
		return service.addQuestion(question);
	}

	public List<Question> getQuestionsForASubject(int subjectId) {
		return service.getQuestionsForASubject(subjectId);
	}

}
