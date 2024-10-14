package com.tus.engg.project.monitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tus.engg.project.entity.SensorData;
import com.tus.engg.project.notifications.EmailNotification;

import jakarta.mail.MessagingException;

@Component
public class HumidityMonitor {
	
	@Autowired
	private EmailNotification emailNotification;
	
	private static final int HUMIDITY_THRESHOLD = 50; // 60 is the recommended threshold for humidity
	private boolean emailTrigger = false;
	
	public void mointorHumidity(List<SensorData> sensorData) {
		for (SensorData data : sensorData) {
			if(HUMIDITY_THRESHOLD < data.getHumidity() && !emailTrigger) {
				try {
					emailNotification.sendNotification();
					emailTrigger = true;
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				break;
			} else {
				System.out.println("SAFEST HUMIDITY RANGE !!!!");
			}
		}
	}

}
