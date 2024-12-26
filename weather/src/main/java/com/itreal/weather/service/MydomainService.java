package com.itreal.weather.service;

import java.util.List;

import com.itreal.weather.model.MydomainRequest;
import com.itreal.weather.model.MydomainResponse;

public interface MydomainService {

	long placeWeatherRequest(MydomainRequest mydomainRequest);
	
	List<MydomainResponse> getHistoyForPincode(Long pincode);
	
	List<MydomainResponse> getHistoyForUser(String userId);

}
