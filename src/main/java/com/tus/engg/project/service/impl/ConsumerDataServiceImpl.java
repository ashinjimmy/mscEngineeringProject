package com.tus.engg.project.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tus.engg.project.entity.SensorData;
import com.tus.engg.project.monitor.HumidityMonitor;
import com.tus.engg.project.repository.ConfigRepository;
import com.tus.engg.project.service.ConsumerDataService;

@Service
public class ConsumerDataServiceImpl implements ConsumerDataService {

	@Autowired
	private ConfigRepository configRepository;

	@Autowired
	private HumidityMonitor humidityMonitor;

	@Override
	public void addConsumedData(JSONObject jsonObject) {

		SensorData consumerData = new SensorData();
		consumerData.setTemperature_c(jsonObject.getInt("temperature"));
		consumerData.setHumidity(jsonObject.getInt("humidity"));
		consumerData.setTimeStamp(LocalDateTime.now());
		configRepository.save(consumerData);

	}

	@Override
	public void fetchAllHumidityValues() {
		List<SensorData> humidityList = configRepository.findAllByHumidityNotNull();
		humidityMonitor.mointorHumidity(humidityList);
	}

}
