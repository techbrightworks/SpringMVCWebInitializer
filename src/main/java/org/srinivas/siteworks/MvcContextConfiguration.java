/**
 * @author SrinivasJasti
 * 
 */
package org.srinivas.siteworks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * The Class MvcContextConfiguration.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.srinivas.siteworks","org.srinivas.siteworks.controller" })
public class MvcContextConfiguration extends WebMvcConfigurerAdapter {


	private static final Logger logger = LoggerFactory.getLogger(MvcContextConfiguration.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
	 */
	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		logger.info("WebMvcContextConfiguration: configureDefaultServletHandling Method");
		configurer.enable();
	}

}
