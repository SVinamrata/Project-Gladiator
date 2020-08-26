package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ResponseDto;
import com.lti.service.ResponseService;

@RestController
@CrossOrigin
public class ResponseController {
	
	@Autowired
	ResponseService responseService;
	
	@PostMapping("/submitResponses")
	public int acceptResponses(List<ResponseDto> responseDtoList) {
		return responseService.addResponses(responseDtoList); 
	}
	
	

}
