package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO muss diese Klasse public sein?
@RestController
public class TemperatureController {

    private final TemperatureService temperaturService;

    public TemperatureController(TemperatureService temperaturService) {
        this.temperaturService = temperaturService;
    }

    @GetMapping("/fahrenheit")
    public String fahrenheit(@RequestParam Double celsius) {
        double fahrenheit = temperaturService.toFahrenheit(celsius);
        return celsius + " °C sind " + fahrenheit + " °F";
    }

}
