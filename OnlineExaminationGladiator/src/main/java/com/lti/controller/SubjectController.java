package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.displaySubject;
import com.lti.model.Subject;
import com.lti.service.SubjectService;

@RestController
@CrossOrigin
public class SubjectController {
	
	@Autowired
	SubjectService service;
	
	public int addNewSubject(Subject subject){
		return service.addNewSubject(subject);
	}
	public boolean updateSubject(Subject subject){
		return service.updateSubject(subject);
	}
	public boolean deleteSubject(int subjectId){
		return service.deleteSubject(subjectId);
	}
	public Subject getSubjectBYSubjectId(int subjectId){
		return service.getSubjectBYSubjectId(subjectId);
	}
	@RequestMapping(path = "/testsAvailable", method = RequestMethod.GET, produces = "application/json")
	public List<displaySubject> listSubjects(){
		return service.listSubjects();
	}

}
