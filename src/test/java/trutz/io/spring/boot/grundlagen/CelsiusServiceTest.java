package trutz.io.spring.boot.grundlagen;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CelsiusServiceTest {

	@Autowired
	public CelsiusService celsiusService;

	@ParameterizedTest(name = "{0} Grad Celsius sind {1} Grad Fahrenheit")
	@MethodSource("celsiusFahrenheitProvider")
	public void testStandardValues(double celsius, double fahrenheit) {
		Assertions.assertEquals(86.0, celsiusService.toFahrenheit(30.0));
	}

	static Stream<Arguments> celsiusFahrenheitProvider() {
		return Stream.of( //
				arguments(0.0, 32.0), // the freezing point of water
				arguments(30.0, 86.0), // a hot day
				arguments(37.0, 98.6), // body temperature
				arguments(100.0, 212.0) // boiling point of water at sea level
		);
	}

}
