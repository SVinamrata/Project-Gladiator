package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.FetchLevelDto;
import com.lti.dto.ResultDto;
import com.lti.dto.ReturnLevelDto;
import com.lti.dto.ScoreDto;
import com.lti.model.Exam;
import com.lti.model.Result;
import com.lti.model.Student;
import com.lti.model.Subject;
import com.lti.repo.ExamDao;
import com.lti.repo.ResultDao;
import com.lti.repo.StudentDao;
import com.lti.repo.SubjectDao;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	ResultDao resultDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	SubjectDao subjectDao;
	
	@Autowired
	ExamDao examDao;
	
	@Override
	public List<ResultDto> getResultOfaStudent(int studentId){
		Student student = studentDao.findAUser(studentId);
		List<Result> resultList =  resultDao.getResultsOfaStudent(student);
		List<ResultDto> resultDtoList = new ArrayList<>();
		for(Result res: resultList) {
			ResultDto resDto = new ResultDto();
			resDto.setUserResultId(res.getUserResultId());
			resDto.setExamId(res.getExamDetail().getExamId());
			resDto.setExamSubject(res.getExamDetail().getTestSubject().getSubjectName());
			resDto.setResultStatus(res.getResultStatus());
			resDto.setScore(res.getScore());
			resDto.setLevelPassed(res.getLevelPassed());
			resultDtoList.add(resDto);
		}
		return resultDtoList;
	} 
	
	public ReturnLevelDto fetchLevelOfStudent(FetchLevelDto fetchLevel) {
		Student student = studentDao.findAUser(fetchLevel.getStudentId());
		Subject subject = subjectDao.getSubjectBYSubjectId(fetchLevel.getSubjectId());
		int currentLevel = resultDao.fetchLevelOfStudent(student, subject);
		ReturnLevelDto returnLevel = new ReturnLevelDto();
		returnLevel.setLevel(currentLevel);
		return returnLevel;
		
	}
	
	public String receiveScore(ScoreDto scoreDto) {
		int id ;
		Exam exam = examDao.findExamById(scoreDto.getExamId());
		Result result = new Result();
		result.setScore(scoreDto.getScore());
		result.setExamDetail(exam);
		result.setLevelPassed(scoreDto.getLevel());
		if(scoreDto.getScore() < 6) {
			result.setResultStatus("Failed");
			id = resultDao.addResult(result);
			return "Failed";
		}
		result.setResultStatus("Passed");
		id = resultDao.addResult(result);
		return "Passed";


	}

}
