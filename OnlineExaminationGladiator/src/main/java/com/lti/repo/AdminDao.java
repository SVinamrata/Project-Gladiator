package com.lti.repo;

import com.lti.model.Admin;

public interface AdminDao {
	int findByEmailPassword(String email , String password);

	Admin findAdminUser(int id);

}
