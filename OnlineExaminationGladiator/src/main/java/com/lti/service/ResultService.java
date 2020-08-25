package com.lti.service;

import java.util.List;

import com.lti.dto.FetchLevelDto;
import com.lti.dto.ResultDto;
import com.lti.dto.ReturnLevelDto;
import com.lti.model.Result;

public interface ResultService {

	List<ResultDto > getResultOfaStudent(int studentId);
	ReturnLevelDto fetchLevelOfStudent(FetchLevelDto fetchLevel);

}