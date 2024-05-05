package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemperatureServiceTest {

    @Test
    void test_37C(@Autowired TemperatureService temperatureService) {
        double computedFahrenheit = temperatureService.toFahrenheit(37.0d);
        double expectedFahrenheit = 98.6d;
        Assertions.assertEquals(expectedFahrenheit, computedFahrenheit, 0.001);
    }

}
