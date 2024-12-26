package com.itreal.weather.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Response;

@FeignClient(name="weather-service", url = "https://api.openweathermap.org/data/2.5")
public interface WeatherApiClient {
	 @GetMapping(value="/weather", consumes = "application/json", produces = "application/json")
	 Response getCurrentWeather(@RequestParam("zip") String zip, 
	                                    @RequestParam("appid") String apiKey);
}
