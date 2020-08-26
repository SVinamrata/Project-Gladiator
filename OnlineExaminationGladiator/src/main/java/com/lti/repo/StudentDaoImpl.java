package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Exam;
import com.lti.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public int addNewStudent(Student student) {
		System.out.println(student.getStudentEmail());
		System.out.println(student.getStudentPassword());
		Student s = em.merge(student);
		return s.getStudentID();
	}

	@Transactional
	public boolean updateStudent(Student student) {
		if (em.find(Student.class, student.getStudentID()) != null) {
			em.merge(student);
			return true;
		}
		return false;
	}

	@Transactional
	public boolean deleteStudent(int studentId) {
		Student student = em.find(Student.class, studentId);
		if (student != null) {
			em.remove(student);
			return true;
		}
		return false;
	}
	@Override
	public boolean isStudentPresent(String email)
	{
		return (Long)em
				.createQuery("select count(c.studentID) from Student c where c.studentEmail=:em")
				.setParameter("em", email)
				.getSingleResult()==1?true:false;
		
	}

	public Student findAUser(int studentId) {
		return em.find(Student.class , studentId);
	}


	@Override	
	public int findByEmailPassword(String studentEmail,String studentPassword) {
		return (Integer) em.createQuery("select s.studentID from Student s where s.studentEmail= :e and s.studentPassword= :pw")
				.setParameter("e", studentEmail)
				.setParameter("pw", studentPassword)
				.getSingleResult();
	}
	
	public List<Student> viewAllStudents() {
		String sql = "select stud from Student stud";
		TypedQuery<Student> qry = em.createQuery(sql, Student.class);
		List<Student> students = qry.getResultList();
		return students;
	}
	
	public List<Student> listStudentsBySubjectId(int subjectId){
		String sql = "select distinct(ex.student) from Exam ex where ex.examSubject.subjectId= :sub ";
		TypedQuery<Student> qry = em.createQuery(sql , Student.class);
		qry.setParameter("sub", subjectId);
		return qry.getResultList();
		
	}

//	public List<Exam> viewAllExamsOfStudent(int studentId) {
//		Student student = em.find(Student.class, studentId);
//		return student.getStudentExams();
//	}

}
