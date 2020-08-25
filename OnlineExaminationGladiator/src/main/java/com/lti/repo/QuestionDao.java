package com.lti.repo;

import java.util.List;

import com.lti.model.Question;
import com.lti.model.Subject;

public interface QuestionDao {
	// public void addQuestion(Question question,Answer answer);
	int addQuestion(Question question);

	List<Question> listQuestions();

	boolean deleteQuestion(int questionId);

	boolean updateQuestion(Question question);

	Question getQuestionByQuestion_id(int questionId);
	
	List<Question> getQuestionsForASubject(int subjectId);
	
	List<Question> fetchQuestionsBySubjectAndLevel(Subject subject , int level);
}
