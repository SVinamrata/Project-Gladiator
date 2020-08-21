package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repo.QuestionDao;
import com.lti.model.Question;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao dao;
	
	public List<Question> listQuestions() {
		return dao.listQuestions();
	}

	public boolean deleteQuestion(int questionId) {
		return dao.deleteQuestion(questionId);
	}

	public boolean updateQuestion(Question question) {
		return dao.updateQuestion(question);
	}

	public Question getQuestionByQuestion_id(int questionId) {
		return dao.getQuestionByQuestion_id(questionId);
	}

	public int addQuestion(Question question) {
		return dao.addQuestion(question);
	}

	public List<Question> getQuestionsForASubject(int subjectId) {
		return dao.getQuestionsForASubject(subjectId);
	}

}
