package com.itreal.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itreal.weather.exception.ResourceNotFoundException;
import com.itreal.weather.model.MydomainRequest;
import com.itreal.weather.model.MydomainResponse;
import com.itreal.weather.service.MydomainService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/mydomain/app")
@Log4j2
public class MydomainController{
	
	@Autowired()
	MydomainService mydomainService;
	
	@PostMapping("/weather")
	public ResponseEntity<Long> placeWeatherRequest(@RequestBody MydomainRequest mydomainRequest){
		long requestId = mydomainService.placeWeatherRequest(mydomainRequest);
		return new ResponseEntity<Long>(requestId,HttpStatus.OK);
	}
	
    @GetMapping("/history")
    public ResponseEntity<List<MydomainResponse>> getHistoryPincode(@RequestParam(value = "postalcode") long pincode) throws ResourceNotFoundException {
        List<MydomainResponse> listmydomainResponse
                = mydomainService.getHistoyForPincode(pincode);
        return new ResponseEntity<>(listmydomainResponse, HttpStatus.OK);
    }
	
    @GetMapping("/historyuser")
    public ResponseEntity<List<MydomainResponse>> getHistoryUser(@RequestParam(value = "userId") String userId) throws ResourceNotFoundException {
        List<MydomainResponse> listmydomainResponse
                = mydomainService.getHistoyForUser(userId);
        return new ResponseEntity<>(listmydomainResponse, HttpStatus.OK);
    }

}
