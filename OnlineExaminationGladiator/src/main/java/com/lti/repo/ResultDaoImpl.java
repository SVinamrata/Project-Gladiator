package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dto.FetchLevelDto;
import com.lti.model.Exam;
import com.lti.model.Result;
import com.lti.model.Student;
import com.lti.model.Subject;

@Repository
public class ResultDaoImpl implements ResultDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Result getResultById(int resultId) {
		return em.find(Result.class, resultId);
	}
	
	public Result getResultByExamID(Exam exam) {
		
		String sql = "select res from Result res where res.examDetail=:ex ";
		TypedQuery<Result> qry = em.createQuery(sql, Result.class);
		qry.setParameter("ex", exam);
		Result result = (Result)qry.getSingleResult();
		return result;
		
	}
	
	public List<Result> getResultsOfaStudent(Student student){
		String sql = "select ex.examResult from Exam ex where ex.student= :stu";
		TypedQuery<Result> qry = em.createQuery(sql, Result.class);
		qry.setParameter("stu", student);
		List<Result> resultList = qry.getResultList();
		return resultList;
	}

	@Transactional
	public int addResult(Result result) {
		Result res = em.merge(result);
		return res.getUserResultId();
	}
	
//	public int fetchLevelOfStudent(Student student , Subject subject) {
//		String sql = "select ex.examResult from Exam ex where ex.student=:stu and ex.examSubject=:sub";
//		TypedQuery<Result> qry = em.createQuery(sql , Result.class);
//		qry.setParameter("stu", student);
//		qry.setParameter("sub", subject);
//		List<Result> resultList = qry.getResultList();
//		int max = 0;
//		for(Result res: resultList) {
//			if(res.getResultStatus()=="Passed" && res.getLevelPassed()>max)
//				max = res.getLevelPassed();
//		}
//		return max;
//	}
	
	public int fetchLevelOfStudent(Student student , Subject subject) {
		String sql = "select ex.examResult from Exam ex where ex.student.studentID=:stu and ex.examSubject.subjectId=:sub";
		TypedQuery<Result> qry = em.createQuery(sql , Result.class);
		qry.setParameter("stu", student.getStudentID());
		qry.setParameter("sub", subject.getSubjectId());
		List<Result> resultList = qry.getResultList();
		int max = 0;
		for(Result res: resultList) {
			System.out.println(res.getResultStatus());
			if(res.getResultStatus().equals("Passed") && res.getLevelPassed()>max)
				max = res.getLevelPassed();
		}
		return max;
	}
// 
//	public List<Result> viewAllResultByMinimumScore(int examId, int score) {
//		// TODO Auto-generated method stub
//		/*
//		String sql = "select result from Result result where result.score> :score and Test_ID=:examId";
//		TypedQuery<Result> query = em.createQuery(sql, Result.class);
//		query.setParameter("TestID", examId);
//		query.setParameter("Score", score);
//		List<Result> resultList = query.getResultList();
//		return resultList;*/
//		
//		return entityManager
//				.createQuery("select result from Result result where result.score> :score and Test_ID=:examId")
//				.setParameter("TestID", examId)
//				.setParameter("Score", score)
//				.getResultList();
//	}

//	public List<Result> viewAllResultByLevel(int level) {
//		// TODO Auto-generated method stub
//		/*emf = Persistence.createEntityManagerFactory("pu");
//		em = emf.createEntityManager();
//		String sql = "select result from Result result where result.LEVEL_PASSED=:level";
//		TypedQuery<Result> query = em.createQuery(sql, Result.class);
//		query.setParameter("Level", level);
//		List<Result> resultList = query.getResultList();
//		return resultList;*/
//		
//		return entityManager
//				.createQuery("select result from Result result where result.LEVEL_PASSED=:level")
//				.setParameter("Level", level)
//				.getResultList();
//		
//	}

}
