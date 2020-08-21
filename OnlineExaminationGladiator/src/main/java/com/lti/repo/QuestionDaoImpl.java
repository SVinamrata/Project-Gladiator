package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Exam;
import com.lti.model.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public int addQuestion(Question question) {
		// TODO Auto-generated method stub
		Question q=em.merge(question);
		return q.getQuestionId();
	}
	
	public List<Question> listQuestions() {
		// TODO Auto-generated method stub
		 String sql = "select ques from Question ques order by ques.questionId";
		 Query qry = em.createQuery(sql);
		 List<Question> users=qry.getResultList();
		 return users;	}
	
	@Transactional
	public boolean deleteQuestion(int questionId) {
		Question ques=em.find(Question.class, questionId);
		if(ques!=null){
			em.remove(ques);
			return true;
			}
		return false;
	}

	@Transactional
	public boolean updateQuestion(Question question) {
		// TODO Auto-generated method stub
		if(em.find(Question.class, question.getQuestionId())!=null){
			em.merge(question);
			return true;
		}
		return false;
	}

	public Question getQuestionByQuestion_id(int questionId) {
		// TODO Auto-generated method stub
		Question ques=em.find(Question.class,questionId);
		return ques;
	}

	public List<Question> getQuestionsForASubject(int subjectId) {
		String sql = "select ques from Question ques where ques.questionSubject = :sub";
		TypedQuery<Question> qry = em.createQuery(sql, Question.class);
		qry.setParameter("sub", subjectId);
		List<Question> questions = qry.getResultList();
		return questions;
	}


}
