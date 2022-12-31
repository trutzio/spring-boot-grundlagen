package trutz.io.spring.boot.grundlagen;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class CelsiusControllerTest {

	@Autowired
	private CelsiusController celsiusController;

	private MockMvc mockMvc;

	@BeforeEach
	void beforeEach() {
		this.mockMvc = standaloneSetup(celsiusController).build();
	}

	@Test
	@DisplayName("celsius Parameter nicht angegeben, also HTTP 400 Antwort")
	public void testNoCelsiusParameter() throws Exception {
		mockMvc.perform(get("/fahrenheit")).andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("celsius Parameter angegeben, also HTTP 200 Antwort")
	public void testWithValidCelsiusParameter() throws Exception {
		mockMvc.perform(get("/fahrenheit?celsius={celsius}", Double.valueOf(30.0))).andExpect(status().isOk());
	}

	@Test
	@DisplayName("celsius Parameter angegeben, aber keine Zahl also HTTP 400 Antwort")
	public void testWithWrongCelsiusParameter() throws Exception {
		mockMvc.perform(get("/fahrenheit?celsius={celsius}", "nonumber")).andExpect(status().isBadRequest());
	}

}
