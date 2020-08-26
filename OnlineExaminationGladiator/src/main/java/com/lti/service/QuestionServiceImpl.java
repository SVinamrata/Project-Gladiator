package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repo.QuestionDao;
import com.lti.repo.SubjectDao;
import com.lti.dto.FetchQuestionsDto;
import com.lti.dto.QuestionDto;
import com.lti.model.Question;
import com.lti.model.Subject;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	SubjectDao subjectDao;
	
	public List<Question> listQuestions() {
		return questionDao.listQuestions();
	}

	public boolean deleteQuestion(int questionId) {
		return questionDao.deleteQuestion(questionId);
	}

	public boolean updateQuestion(Question question) {
		return questionDao.updateQuestion(question);
	}

	public Question getQuestionByQuestion_id(int questionId) {
		return questionDao.getQuestionByQuestion_id(questionId);
	}

	public int addQuestion(Question question) {
		return questionDao.addQuestion(question);
	}

	public List<Question> getQuestionsForASubject(int subjectId) {
		return questionDao.getQuestionsForASubject(subjectId);
	}
	
	public List<QuestionDto> fetchQuestionsBySubjectAndLevel(FetchQuestionsDto fetchQuestions){
		Subject subject = subjectDao.getSubjectBYSubjectId(fetchQuestions.getSubjectId());
		List<Question> questions = questionDao.fetchQuestionsBySubjectAndLevel(subject, fetchQuestions.getLevel());
		List<QuestionDto> questionsDto = new ArrayList<QuestionDto>();
		for(Question ques: questions) {
			QuestionDto dto = new QuestionDto();
			dto.setQuestionId(ques.getQuestionId());
			dto.setQuestion(ques.getQuestion());
			dto.setChoiceOne(ques.getChoiceOne());
			dto.setChoiceTwo(ques.getChoiceTwo());
			dto.setChoiceThree(ques.getChoiceThree());
			dto.setChoiceFour(ques.getChoiceFour());
			dto.setCorrectAns(ques.getCorrectAns());
			questionsDto.add(dto);
		}
		return questionsDto;
	}

}
