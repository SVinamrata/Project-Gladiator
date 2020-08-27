package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.model.Admin;
import com.lti.model.Student;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public int findByEmailPassword(String adminEmail , String adminPwd) {
		// TODO Auto-generated method stub
		return (Integer) em.createQuery("select a.adminId from Admin a where a.adminEmail= :e and a.adminPwd= :pw")
				.setParameter("e", adminEmail)
				.setParameter("pw", adminPwd)
				.getSingleResult();
	}
	
	@Override
	public Admin findAdminUser(int adminId) {
		// TODO Auto-generated method stub
		return em.find(Admin.class , adminId);
	}

		

}
