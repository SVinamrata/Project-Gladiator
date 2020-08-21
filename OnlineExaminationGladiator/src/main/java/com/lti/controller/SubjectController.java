package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Subject> listSubjects(){
		return service.listSubjects();
	}

}
