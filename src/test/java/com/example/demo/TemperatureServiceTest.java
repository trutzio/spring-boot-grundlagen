package com.example.demo;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TemperatureService.class)
class TemperatureServiceTest {

	private final TemperatureService temperatureService;

	TemperatureServiceTest(@Autowired TemperatureService temperatureService) {
		this.temperatureService = temperatureService;
	}

	@ParameterizedTest
	@MethodSource("provideCelsiusToFahrenheit")
	void testCelsius0(double celsius, double expectedFahrenheit) {
		double fahrenheit = temperatureService.toFahrenheit(celsius);
		Assertions.assertEquals(expectedFahrenheit, fahrenheit);
	}

	private static Stream<Arguments> provideCelsiusToFahrenheit() {
		return Stream.of(
				Arguments.of(0.0, 32.0),
				Arguments.of(100.0, 212.0),
				Arguments.of(-100.0, -148.0));
	}

}
