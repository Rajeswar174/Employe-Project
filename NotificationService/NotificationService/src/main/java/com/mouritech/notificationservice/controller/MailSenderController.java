package com.mouritech.notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.notificationservice.entity.NotificationRequest;
import com.mouritech.notificationservice.service.MailSenderService;

@RestController
@RequestMapping("/notifications")
public class MailSenderController {
	
	
	@Autowired
	private  MailSenderService mailSenderService;
	
	// This controller can have endpoints to trigger email sending
	// For example, an endpoint to send a notification email
	@PostMapping("/send-email")
	public ResponseEntity<String> sendEmail(@RequestBody NotificationRequest notificationRequest) {
		try {
			mailSenderService.sendEmail(notificationRequest);
			return ResponseEntity.ok("Email sent successfully to " + notificationRequest.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
		}
		 
	 }

}
