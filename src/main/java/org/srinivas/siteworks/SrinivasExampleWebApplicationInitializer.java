/**
 * @author SrinivasJasti
 * 
 */
package org.srinivas.siteworks;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * The Class SrinivasExampleWebApplicationInitializer.
 */
public class SrinivasExampleWebApplicationInitializer implements WebApplicationInitializer {


	private static final Logger logger = LoggerFactory.getLogger(SrinivasExampleWebApplicationInitializer.class);


	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	@Override
	public void onStartup(ServletContext container) {
		logger.info("Started to pickup the annotated classes");
		startServlet(container);
	}

	/**
	 * Start servlet.
	 * 
	 * @param container   the ServletContext
	 */
	private void startServlet(final ServletContext container) {
		WebApplicationContext dispatcherContext = registerContext(MvcContextConfiguration.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
		ServletRegistration.Dynamic dispatcher;
		dispatcher = container.addServlet("dispatcher",dispatcherServlet);		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.html");
	}

	/**
	 * Register context.
	 * 
	 * @param annotatedClasses the Class type variable argument of classes that needs to be registered to the context.
	 * @return the web application context
	 */
	private WebApplicationContext registerContext(final Class<?>... annotatedClasses) {
		logger.info("Using AnnotationConfigWebApplicationContext createContext");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
	}
	
	
	
}
