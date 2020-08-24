package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.generateExamId;
import com.lti.model.Exam;
import com.lti.model.Question;
import com.lti.model.Student;
import com.lti.model.Subject;
import com.lti.repo.ExamDao;
import com.lti.repo.StudentDao;
import com.lti.repo.SubjectDao;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	ExamDao dao;

	@Autowired
	private SubjectDao subjectDao;

	@Autowired
	private StudentDao studentDao;
	
	public int addNewExam(generateExamId generateExamId) {
		List<Exam> list=new ArrayList<>();
		Student student=studentDao.findAUser(generateExamId.getStudentId());
		Subject subject=subjectDao.getSubjectBYSubjectId(generateExamId.getSubjectId());
		Exam exam=new Exam();
		exam.setStudent(student);
		exam.setTestSubject(subject);
		list.add(exam);
		student.setStudentExams(list);
		subject.setSubjectExams(list);
		return dao.addNewExam(exam);
	}

	public List<Exam> listAllExams() {
		return dao.listAllExams();
	}

	public List<Exam> listExamsOfASubject(Subject subject) {
		return dao.listExamsOfASubject(subject);
	}

	public Exam findExamById(int examId) {
		return dao.findExamById(examId);
	}

	public List<Exam> listAllExamsOfAStudent(Student student) {
		return dao.listAllExamsOfAStudent(student);
	}


}
