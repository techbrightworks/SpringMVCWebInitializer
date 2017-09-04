/**
 * @author SrinivasJasti
 * 
 */
package org.srinivas.siteworks.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * The Class HelloWorldController.
 */
@Controller
@RequestMapping(value = "/helloworld.html")
public class HelloWorldController {
	

	public static final String STRING_MESSAGE_WELCOME_TO_WEB_APPLICATION_INITIALISER = "Welcome to WebApplication Initialiser";
	

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	/**
	 * Hello page.
	 * 
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String helloPage(Model model) {
		logger.info("HelloWorldController");
		model.addAttribute("message",STRING_MESSAGE_WELCOME_TO_WEB_APPLICATION_INITIALISER);
		return "helloworld";
	}
}
