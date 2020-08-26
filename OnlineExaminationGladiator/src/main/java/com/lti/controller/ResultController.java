package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.FetchLevelDto;
import com.lti.dto.ResultDto;
import com.lti.dto.ResultStatus;
import com.lti.dto.ReturnLevelDto;
import com.lti.dto.ScoreDto;
import com.lti.dto.StudentIdDto;
import com.lti.model.Result;
import com.lti.service.ResultService;

@RestController
@CrossOrigin
public class ResultController {
	
	@Autowired
	ResultService resultService;
	
	@PostMapping("/result")
//	@RequestMapping(path = "/result" , consumes = "text/plain" , produces = "application/json")
	public List<ResultDto> getResultsOfaStudent(@RequestBody StudentIdDto studentId){
		return resultService.getResultOfaStudent(studentId.getStudentId());
	}
	
	@PostMapping("/levelFetch")
	public ReturnLevelDto fetchLevel(@RequestBody FetchLevelDto fetchLevel ) {
		return resultService.fetchLevelOfStudent(fetchLevel);
	}
	
	@PostMapping("/acceptScore")
	public ResultStatus receiveScore(@RequestBody ScoreDto score) {
		ResultStatus rs = new ResultStatus();
		rs.setStatus(resultService.receiveScore(score));
		return rs;
	}

}
