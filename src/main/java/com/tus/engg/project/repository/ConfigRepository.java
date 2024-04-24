package com.tus.engg.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tus.engg.project.entity.SensorData;

@Repository
public interface ConfigRepository extends JpaRepository<SensorData, Long>{

	List<SensorData> findAllByHumidityNotNull();

}
