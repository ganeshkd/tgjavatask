package com.itreal.weather.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MydomainResponse {
	private long id;
	private String userId;
	private long pincode;
	private String country;
	//private LocalDate txtDate;
	private double temperature;
	private double temperatureMin;
	private double temperatureMax;
	private long pressure;
	private long humidity;
	private long seaLevel;
	private long visibility;
	private double windSpeed;

}
