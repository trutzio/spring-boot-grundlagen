package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TemperatureService.class)
class TemperatureServiceTest {

	@Test
	void testCelsius0(@Autowired TemperatureService temperatureService) {
		double fahrenheit = temperatureService.toFahrenheit(0.0);
		assert fahrenheit == 32.0;
	}

}
