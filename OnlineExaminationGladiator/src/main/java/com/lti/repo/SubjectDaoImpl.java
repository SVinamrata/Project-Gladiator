package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
	@Transactional
	public List<Subject> listSubjects() {
		String sql="select sub from Subject sub order by sub.subjectId";
		Query qry=em.createQuery(sql);
		List<Subject> users=qry.getResultList();
		return users;
	}

}
