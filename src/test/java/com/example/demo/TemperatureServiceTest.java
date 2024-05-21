package com.example.demo;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemperatureServiceTest {

    @Autowired
    private TemperatureService temperatureService;

    @ParameterizedTest
    @MethodSource("celsiusFahrenheitSource")
    void test_toFahrenheit(double celsius, double expectedFahrenheit) {
        double computedFahrenheit = temperatureService.toFahrenheit(celsius);
        Assertions.assertEquals(expectedFahrenheit, computedFahrenheit, 0.001d);
    }

    private static Stream<Arguments> celsiusFahrenheitSource() {
        return Stream.of(
            Arguments.of(37.0d, 98.6d),
            Arguments.of(0.0d, 32.0d)
        );
    }

}
