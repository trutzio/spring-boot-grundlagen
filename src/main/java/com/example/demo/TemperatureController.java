package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TemperatureController {

    private final TemperatureService temperaturService;

    TemperatureController(TemperatureService temperaturService) {
        this.temperaturService = temperaturService;
    }

    @GetMapping("/fahrenheit")
    String fahrenheit(@RequestParam Double celsius) {
        double fahrenheit = temperaturService.toFahrenheit(celsius);
        return String.format("%s °C sind %s °F", celsius, fahrenheit);
    }

}
