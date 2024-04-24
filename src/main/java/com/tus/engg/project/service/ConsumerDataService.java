package com.tus.engg.project.service;

import org.json.JSONObject;

public interface ConsumerDataService {

	void addConsumedData(JSONObject jsonObject);

	void fetchAllHumidityValues();

}
