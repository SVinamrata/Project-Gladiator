package com.lti.service;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.displaySubject;
import com.lti.model.Subject;
import com.lti.repo.SubjectDao;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDao dao;
	
	public int addNewSubject(Subject subject) {
		return dao.addNewSubject(subject);
	}

	public boolean updateSubject(Subject subject) {
		return dao.updateSubject(subject);
	}

	public boolean deleteSubject(int subjectId) {
		return dao.deleteSubject(subjectId);
	}

	public Subject getSubjectBYSubjectId(int subjectId) {
		return dao.getSubjectBYSubjectId(subjectId);
	}

	public List<displaySubject> listSubjects() {
		List<Subject> subjectList =  dao.listSubjects();
		List<displaySubject> displaySubjectList = new ArrayList<displaySubject>();
		for(Subject sub: subjectList ) {
			displaySubject disSub = new displaySubject();
			disSub.setSubjectId(sub.getSubjectId());
			disSub.setSubjectName(sub.getSubjectName());
			displaySubjectList.add(disSub);
		}
		return displaySubjectList;
		
	}

}
