package trutz.io.spring.boot.grundlagen;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CelsiusService {

	public double toFahrenheit(@NonNull Double celsius) {
		return (celsius * 9.0) / 5.0 + 32.0;
	}

}
