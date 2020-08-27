package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.exception.AdminServiceException;
import com.lti.model.Admin;
import com.lti.repo.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao dao;

	@Override
	public Admin loginAdmin(String adminEmail, String adminPwd) {
		try {
			int id= dao.findByEmailPassword(adminEmail, adminPwd);
			Admin a= dao.findAdminUser(id);
			return a;
		}catch (EmptyResultDataAccessException e) {
			throw new AdminServiceException("Invalid Credentials");
		}
	}

	

}
