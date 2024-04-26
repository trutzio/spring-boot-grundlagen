package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FahrenheitCelsiusController {

    /**
     * Umrechnunsgsformel °F = °C * 1.8 + 32
     * 
     * @param celsius
     * @return
     */
    @GetMapping("to_farenhenheit")
    public String toFahrenheit(@RequestParam Double celsius) {
        double fahrenheit = celsius.doubleValue() * 1.8 + 32;
        return celsius + " °C sind " + fahrenheit + " °F";
    }
    

}
