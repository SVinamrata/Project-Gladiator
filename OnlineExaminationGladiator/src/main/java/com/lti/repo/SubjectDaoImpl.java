package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public int addNewSubject(Subject subject) {
		Subject sub=em.merge(subject);
		return sub.getSubjectId();
	}
	@Transactional
	public boolean updateSubject(Subject subject) {
		if(em.find(Subject.class, subject.getSubjectId())!=null){
			em.merge(subject);
			return true;
		}
		return false;
	}
	@Transactional
	public boolean deleteSubject(int subjectId) {
		Subject sub=em.find(Subject.class, subjectId);
		if(sub!=null){
			em.remove(sub);
			return true;
		}
		return false;
	}
	@Transactional
	public Subject getSubjectBYSubjectId(int subjectId) {
		Subject sub=em.find(Subject.class, subjectId);
		return sub;
	}
	public List<Subject> listSubjects() {
		return em.createNamedQuery("fetch-all").getResultList();
	}

}
