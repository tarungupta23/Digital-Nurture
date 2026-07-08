package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

/**
 * REST - Country Web Service
 * REST - Get country based on country code
 */
@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService countryService;

	/**
	 * GET http://localhost:8083/country
	 *
	 * Loads the India bean from country.xml (Spring configuration) and
	 * returns it. Because Country is a POJO with getters, Spring's
	 * HttpMessageConverter (Jackson, on the classpath via
	 * spring-boot-starter-web) automatically serializes it to JSON in the
	 * HTTP response body - no manual JSON building is required.
	 */
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country);

		LOGGER.info("END");
		return country;
	}

	/**
	 * GET http://localhost:8083/countries/{code}  (case insensitive code)
	 *
	 * Delegates the lookup to countryService.getCountry(code).
	 */
	@GetMapping("/countries/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable String code) {
		LOGGER.info("START");

		Country country = countryService.getCountry(code);

		ResponseEntity<Country> response;
		if (country != null) {
			response = ResponseEntity.ok(country);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		LOGGER.info("END");
		return response;
	}

}
