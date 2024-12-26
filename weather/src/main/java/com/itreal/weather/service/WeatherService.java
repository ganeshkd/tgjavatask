package com.itreal.weather.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itreal.weather.external.client.WeatherApiClient;
import com.itreal.weather.external.response.WeatherResponse;

import feign.FeignException;
import feign.Response;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class WeatherService {
	
	private final WeatherApiClient weatherApiClient;
	
	public WeatherService(WeatherApiClient weatherApiClient) {
		this.weatherApiClient = weatherApiClient;
	}

	public WeatherResponse getWeatherForPincode(String pincode) {
		try {
			Response response = weatherApiClient.getCurrentWeather(pincode ,"2c7821a6f5498727d278ff02f28be9a3");

			//create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			
			//convert json string to object
			WeatherResponse wr = objectMapper.readValue(response.body().asInputStream(), WeatherResponse.class);
			
			log.info("Fetching weather data for pincode: {}", wr);
			
			return wr;
		} catch (FeignException.NotFound e) {
			log.error("pincode not found: {}", pincode);
		} catch (FeignException e) {
			log.error("Error fetching weather data: {}");
		} catch (IOException e) {
			log.error("Error IOException: {}");
		}
		return null;
	}
}

