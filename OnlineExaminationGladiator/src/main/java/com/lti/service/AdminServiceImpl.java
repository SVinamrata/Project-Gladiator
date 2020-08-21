package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repo.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao dao;

	public boolean loginAdmin(int userId, String password) {
		return dao.loginAdmin(userId, password);
	}

}
