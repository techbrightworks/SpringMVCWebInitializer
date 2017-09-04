/**
 * @author SrinivasJasti
 * 
 */
package org.srinivas.siteworks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * The Class ViewConfiguration.
 */
@Configuration
public class ViewConfiguration {


	private static final Logger logger = LoggerFactory.getLogger(ViewConfiguration.class);

	/**
	 * View resolver.
	 * 
	 * @return the Resolved view
	 */
	@Bean
	public ViewResolver viewResolver() {
		logger.info("ViewConfiguration viewResolver()");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setOrder(1);
		viewResolver.setPrefix("/WEB-INF/displays/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
