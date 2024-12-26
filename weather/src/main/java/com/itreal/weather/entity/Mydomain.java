package com.itreal.weather.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="weather_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mydomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="userId")
	private String userId;
	@Column(name="pincode")
	private long pincode;
	@Column(name="txnDate")
	private LocalDate txtDate;
	@Column(name="country")
	private String country;
	@Column(name="temperature")
	private double temperature;
	@Column(name = "temperatureMin")
	private double temperatureMin;
	@Column(name = "temperatureMax")
	private double temperatureMax;
	@Column(name = "pressure")
	private long pressure;
	@Column(name = "humidity")
	private long humidity;
	@Column(name = "seaLevel")
	private long seaLevel;
	@Column(name = "visibility")
	private long visibility;
	@Column(name = "windSpeed")
	private double windSpeed;

}
