package com.itreal.weather.service;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreal.weather.entity.Mydomain;
import com.itreal.weather.external.response.WeatherResponse;
import com.itreal.weather.model.MydomainRequest;
import com.itreal.weather.model.MydomainResponse;
import com.itreal.weather.repository.MydomainRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MydomainServiceImpl implements MydomainService {
	
	@Autowired
	MydomainRepository mydomainRepository;
	@Autowired
	WeatherService weatherService;
	
	@Override
	public long placeWeatherRequest(MydomainRequest mydomainRequest) {
		
		//You have to call external client.
		WeatherResponse wr = weatherService.getWeatherForPincode(""+mydomainRequest.getPincode()+","+mydomainRequest.getCountry());
		Mydomain mydomain = Mydomain.builder()
				.userId(mydomainRequest.getUser())
				.pincode(mydomainRequest.getPincode())
				.txtDate(LocalDate.now())
				.country(mydomainRequest.getCountry())
				.temperature(wr.getMain().getTemp())
				.temperatureMin(wr.getMain().getTemp_min())
				.temperatureMax(wr.getMain().getTemp_max())
				.pressure(wr.getMain().getPressure())
				.humidity(wr.getMain().getHumidity())
				.seaLevel(wr.getMain().getSea_level())
				.visibility(wr.getVisibility())
				.windSpeed(wr.getWind().getSpeed())
				.build();
		mydomainRepository.save(mydomain);
		log.info("Weather request Created");
		return mydomain.getId();
	}

	@Override
	public List<MydomainResponse> getHistoyForPincode(Long pincode){

	        log.info("Get the getHistoyForPincode for: {}", pincode);

	        List<Mydomain> listMydomain = mydomainRepository.findByPincode(pincode);
	               
	        List<MydomainResponse> listMydomainResponse = new ArrayList<MydomainResponse>();
	        MydomainResponse target;
	        for(Mydomain mydomain:listMydomain ) {
	        	target = new MydomainResponse();
	        	copyProperties(mydomain, target);
	        	listMydomainResponse.add(target);
	        }
	        

	        return listMydomainResponse;
	}

	@Override
	public List<MydomainResponse> getHistoyForUser(String userId) {
        log.info("Get the getHistoyForUser for: {}", userId);

        List<Mydomain> listMydomain = mydomainRepository.findByUser(userId);
               
        List<MydomainResponse> listMydomainResponse = new ArrayList<MydomainResponse>();
        MydomainResponse target;
        for(Mydomain mydomain:listMydomain ) {
        	target = new MydomainResponse();
        	copyProperties(mydomain, target);
        	listMydomainResponse.add(target);
        }
        

        return listMydomainResponse;
	}

}