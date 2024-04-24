package com.tus.engg.project.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tus.engg.project.service.ConsumerDataService;

@EnableScheduling
@Component
public class Scheduler {
	
	
	private ConsumerDataService consumerDataService;
	
	public Scheduler(ConsumerDataService consumerDataService) {
		this.consumerDataService = consumerDataService;
	}


	@Scheduled(fixedRate = 600000)
	public void scheduledData() {
		System.out.println("Schedule Active!!!");
		 consumerDataService.fetchAllHumidityValues();
	}

}
