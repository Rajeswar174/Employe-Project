package com.mouritech.notificationservice.service;

import com.mouritech.notificationservice.entity.NotificationRequest;

public interface MailSenderService {
	
	
	public void sendEmail(NotificationRequest notificationRequest);

}
