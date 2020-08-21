package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.model.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@PersistenceContext
	EntityManager em;

	public boolean loginAdmin(int userId, String password) {
		String sql = "select ad from Admin ad where ad.adminId = :aid and ad.adminPwd = :ap";
		TypedQuery<Admin> qry = em.createQuery(sql, Admin.class);
		qry.setParameter("aid", userId);
		qry.setParameter("ap", password);
		List<Admin> admin = qry.getResultList();
		if (admin.isEmpty())
			return false;

		return true;
	}
	

}
