package com.lti.repo;

import java.util.List;

import com.lti.model.Exam;
import com.lti.model.Result;
import com.lti.model.Student;
import com.lti.model.Subject;


public interface ResultDao {
	int addResult(Result result);
	public Result getResultById(int resultId);
	public Result getResultByExamID(Exam exam);
	List<Result> getResultsOfaStudent(Student student);
//	List<Result> viewAllResultByMinimumScore(int examId,int score);
//	List<Result> viewAllResultByLevel(int level);
	int fetchLevelOfStudent(Student student , Subject subject);
	

}
