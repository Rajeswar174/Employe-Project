package com.mouritech.notificationservice.serviceimpl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mouritech.notificationservice.dao.NotificationRepo;
import com.mouritech.notificationservice.entity.NotificationRequest;
import com.mouritech.notificationservice.service.MailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class MailSenderServiceImpl implements MailSenderService {
	
	
	
	@Autowired
	private NotificationRepo notificationRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	@Async("messageExecutor")
	public void sendEmail(NotificationRequest notificationRequest) {
		final Logger log = LoggerFactory.getLogger(MailSenderServiceImpl.class);
		 log.info("Thread: {}, sending email to {}", Thread.currentThread().getName(), notificationRequest.getEmail());
		// Save the notification request to the database
		SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(notificationRequest.getEmail());
	    message.setSubject("Notification from Notification Service");
	    message.setText("Hello " + notificationRequest.getName() + ",\n\n" + notificationRequest.getMessage());
	    message.setFrom("rajeswarb.in@mouritech.com");
	    javaMailSender.send(message);
	    notificationRepo.save(notificationRequest);
	    log.info("Email sent to " + notificationRequest.getName() + " at " + notificationRequest.getEmail());
	}

	

}
