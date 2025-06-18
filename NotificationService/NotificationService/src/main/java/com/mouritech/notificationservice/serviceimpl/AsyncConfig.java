package com.mouritech.notificationservice.serviceimpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {
	
	
	@Bean("messageExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(8);
		executor.setQueueCapacity(1000);
		executor.setThreadNamePrefix("MessageSync-");
		executor.initialize();
		return executor;
	}

}
