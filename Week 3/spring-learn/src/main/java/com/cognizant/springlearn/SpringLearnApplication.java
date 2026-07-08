package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hands on 1 - Spring Web project created using Spring Initializr.
 * Hands on 4 - Load Country bean from Spring configuration XML (country.xml).
 */
@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("START");

		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("SpringLearnApplication started successfully.");

		SpringLearnApplication app = new SpringLearnApplication();
		app.displayCountry();

		LOGGER.info("END");
	}

	/**
	 * Hands on 4: Reads the country bean from country.xml Spring configuration
	 * file and displays the country details.
	 */
	public void displayCountry() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());

		LOGGER.info("END");
	}

}
