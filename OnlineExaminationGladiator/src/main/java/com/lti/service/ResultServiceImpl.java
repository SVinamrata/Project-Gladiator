package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ResultDto;
import com.lti.model.Result;
import com.lti.model.Student;
import com.lti.repo.ResultDao;
import com.lti.repo.StudentDao;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	ResultDao resultDao;
	
	@Autowired
	StudentDao studentDao;
	
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

}
