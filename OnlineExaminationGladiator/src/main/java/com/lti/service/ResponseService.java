package com.lti.service;

import java.util.List;

import com.lti.dto.ResponseDto;

public interface ResponseService {

	int addResponses(List<ResponseDto> responseDtoList);

}