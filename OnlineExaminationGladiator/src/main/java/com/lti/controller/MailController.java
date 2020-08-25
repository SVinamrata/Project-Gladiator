package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Student;

@RestController
public class MailController {
	@Autowired
	private MailSender mailSender;
	
	@CrossOrigin
	@RequestMapping("/hello")
	public String hello(@RequestBody Student student)
	{
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("AV3.Private.Group@gmail.com");
		message.setTo(student.getStudentEmail());
		message.setSubject("Welcome to AV3 Private Group");
		message.setText("Congratulations you have been successfully registered with AV3 Private Group. We wish you a bright future ahead.");
		mailSender.send(message);
		
		return "Welcome to Spring REST";
	}

}
