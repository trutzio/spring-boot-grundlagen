package trutz.io.spring.boot.grundlagen;

import org.springframework.stereotype.Service;

@Service
public class CelsiusService {
	
	public double toFahrenheit(double celsius) {
		return (celsius * 9.0)/5.0 + 32.0;
	} 
	
}
