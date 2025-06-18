package com.mouritech.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	
	public JavaMailSender javaMailSender() {
		return null;
		
	}

}
