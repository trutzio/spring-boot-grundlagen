package com.example.demo;

import org.springframework.stereotype.Service;

@Service
class TemperatureService {

    Double toFahrenheit(Double celsius) {
        return celsius.doubleValue() * 1.8 + 32;
    }

}
