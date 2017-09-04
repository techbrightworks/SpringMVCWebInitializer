/**
 * @author SrinivasJasti
 * 
 */

package or.srinivas.siteworks.controllers;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.srinivas.siteworks.controllers.HelloWorldController;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * The Class HelloWorldControllerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HelloWorldControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldControllerTest.class);

	@Autowired
	private HelloWorldController helloWorldController;

	/**
	 * Test helloPage method of HelloWorldController
	 */
	@Test
	public void testHelloPage() {

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.helloWorldController).build();
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/helloworld.html"))
					.andExpect(status().isOk())
					.andExpect(view().name("helloworld"))
					.andExpect(forwardedUrl("helloworld"))
					.andExpect(handler().methodName("helloPage"))
					.andExpect(
							model().attribute(
									"message",
									HelloWorldController.STRING_MESSAGE_WELCOME_TO_WEB_APPLICATION_INITIALISER));
		} catch (Exception e) {
			logger.info(e.getMessage());
			fail("Failed Due to: "+e.getMessage());		
		}

	}

	/**
	 * The Class HelloWorldControllerTestConfiguration.
	 */
	@Configuration
	static class HelloWorldControllerTestConfiguration {

		@Bean
		public HelloWorldController helloWorldController() {
			return new HelloWorldController();
		}
	}

}
