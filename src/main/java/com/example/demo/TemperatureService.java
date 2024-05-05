package com.example.demo;

import org.springframework.stereotype.Service;

@Service
class TemperatureService {

    /**
     * Berechnet Grad Celsius in Grad Fahrenheit.
     * Siehe auch https://www.fahrenheit-umrechnen.de/
     * 
     * @param celsius Grad Celsius
     * @return Grad Fahrenheit
     */
    Double toFahrenheit(Double celsius) {
        return celsius * 1.8d + 32;
    }

}
