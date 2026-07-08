package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Week 3 REST hands-on project:
 *  - Hello World RESTful Web Service      (HelloController)
 *  - REST - Country Web Service           (CountryController.getCountryIndia)
 *  - REST - Get country based on code     (CountryController.getCountry)
 */
@SpringBootApplication
public class SpringLearnRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnRestApplication.class, args);
	}

}
