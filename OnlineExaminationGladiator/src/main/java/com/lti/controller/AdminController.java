package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.Status.StatusType;
import com.lti.controller.StudentController.loginStatus;
import com.lti.dto.LoginDto;
import com.lti.exception.AdminServiceException;
import com.lti.exception.StudentServiceException;
import com.lti.model.Admin;
import com.lti.model.Question;
import com.lti.service.AdminService;
import com.lti.service.QuestionService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService admin;

	@PostMapping("/loginAdmin")
	public loginStatus loginAdmin(@RequestBody LoginDto loginDto){
		loginStatus loginStatus= new loginStatus();
		try {
			Admin a=admin.loginAdmin(loginDto.getEmail(), loginDto.getPassword());
			loginStatus.setAdminId(a.getAdminId());
			loginStatus.setMessage("Login Successful");
			loginStatus.setAdminName(a.getAdminName());
			loginStatus.setStatus(StatusType.SUCCESS);
		} catch (AdminServiceException e) {
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
		}
		return loginStatus;
	}
	
	public static class loginStatus extends Status{
		private int adminId;
		private String adminName;
		
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminName() {
			return adminName;
		}
		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}
		
	}

}
