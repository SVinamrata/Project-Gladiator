package com.lti.service;

import java.util.List;

import com.lti.model.Question;

public interface QuestionService {
	
	List<Question> listQuestions();
	boolean deleteQuestion(int questionId);
	boolean updateQuestion(Question question);
	Question getQuestionByQuestion_id(int questionId);
	int addQuestion(Question question);
	List<Question> getQuestionsForASubject(int subjectId);

}
