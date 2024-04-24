package com.tus.engg.project.kafka;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.tus.engg.project.service.ConsumerDataService;

public class KafkaConsumerDataCollection {
	
	@Autowired
	private ConsumerDataService consumerDataService;

	private final static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDataCollection.class);

	@KafkaListener(topics = "testnum")
	public void listen(String message) {
		LOGGER.info("	Consumed Sensor Data: " + message 		); // {"temperature": 18, "humidity": 66}
		dataFormatChange(message);
	}

	private void dataFormatChange(String message) {
		consumerDataService.addConsumedData(new JSONObject(message));
	}
}
