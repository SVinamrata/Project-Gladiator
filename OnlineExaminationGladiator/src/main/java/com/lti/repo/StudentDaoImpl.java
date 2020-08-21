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

	public Student findAUser(int studentId) {
		return em.find(Student.class , studentId);
	}

	public boolean loginStudent(int userId, String password) {
		String sql = "select stud from Student stud where stud.studentID = :sid and stud.studentPassword = :sp";
		TypedQuery<Student> qry = em.createQuery(sql, Student.class);
		qry.setParameter("sid", userId);
		qry.setParameter("sp", password);
		List<Student> students = qry.getResultList();
		if (students.isEmpty())
			return false;

		return true;
		
	}

	public List<Student> viewAllStudents() {
		String sql = "select stud from Student stud";
		TypedQuery<Student> qry = em.createQuery(sql, Student.class);
		List<Student> students = qry.getResultList();
		return students;
	}

//	public List<Exam> viewAllExamsOfStudent(int studentId) {
//		Student student = em.find(Student.class, studentId);
//		return student.getStudentExams();
//	}

}
