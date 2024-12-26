package com.itreal.weather.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.jknack.handlebars.Options;
import com.google.common.base.Optional;
import com.itreal.weather.entity.Mydomain;
import com.itreal.weather.model.MydomainResponse;
import com.itreal.weather.repository.MydomainRepository;

@SpringBootTest
public class MydomainServiceImplTest {
	
	@Mock
	MydomainRepository mydomainRepository;
	
	@Mock
	WeatherService weatherService;

	@InjectMocks
	MydomainService mydomainService = new MydomainServiceImpl();
	
	@DisplayName("getHistoyForPincode ")
	@Test
	void test_When_Pincode_Avialable() {
		
		//mocking
		List<Mydomain> listMydomain = getMockPincode();
		//calling
		when(mydomainRepository.findByPincode(anyLong()))
		.thenReturn(getMockPincode());
		List<MydomainResponse> lmydomainResponse = mydomainService.getHistoyForPincode(560001L);
		//verification
		verify(mydomainRepository, times(1)).findByPincode(anyLong());
		//Assert
		Assertions.assertNotNull(lmydomainResponse);
		Assertions.assertEquals(2,lmydomainResponse.size());
		
	}
	void test_When_Pincode_NotAvialable() {
		
		when(mydomainRepository.findByPincode(anyLong()))
		.thenReturn((List<Mydomain>) Optional.of(null));
		
		verify(mydomainRepository, times(1)).findByPincode(anyLong());
		
		Assertions.assertNull(mydomainRepository);
		
	}
	private List<Mydomain> getMockPincode() {
		List<Mydomain> lmydomain = new ArrayList<Mydomain>();
		Mydomain mydomain = new Mydomain(1, "Rama", 560001, LocalDate.now(), "in", 24.5, 23.1, 26.7, 0, 0, 0, 0, 40.24);
		lmydomain.add(mydomain);
		mydomain = Mydomain.builder()
					.id(2)
					.userId("Sita")
					.pincode(560001)
					.txtDate(LocalDate.now())
					.country("in")
					.temperature(27.1)
					.temperatureMin(26.1)
					.temperatureMax(32.1)
					.humidity(100)
					.pressure(345)
					.seaLevel(12)
					.visibility(1)
					.windSpeed(42.71)
					.build();
		lmydomain.add(mydomain);
		return lmydomain;
	}
}
