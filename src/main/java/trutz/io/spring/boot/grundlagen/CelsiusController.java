package trutz.io.spring.boot.grundlagen;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CelsiusController {

	@Autowired
	private CelsiusService celsiusService;

	@GetMapping("/fahrenheit")
	public ResponseEntity<Double> toFahrenheit(Optional<Double> celsius) {
		return celsius.map(celsiusService::toFahrenheit) //
				.map(ResponseEntity::ok) //
				.orElse(ResponseEntity.badRequest().build());
	}

}
