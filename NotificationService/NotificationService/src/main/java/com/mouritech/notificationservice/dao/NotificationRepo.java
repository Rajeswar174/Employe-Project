package com.mouritech.notificationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.notificationservice.entity.NotificationRequest;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationRequest, Long> {
	// This interface will automatically inherit CRUD operations from JpaRepository
	// No additional methods are needed unless custom queries are required.

}
