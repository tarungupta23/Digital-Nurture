package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;

/**
 * REST - Get country based on country code.
 *
 * Loads the country list defined in country.xml and provides a
 * case-insensitive lookup by ISO country code.
 */
@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	private final List<Country> countryList;

	@SuppressWarnings("unchecked")
	public CountryService() {
		LOGGER.debug("Loading country list from country.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		this.countryList = (List<Country>) context.getBean("countryList", List.class);
	}

	/**
	 * Get country list from country.xml, iterate through the list and make
	 * a case insensitive match of country code.
	 *
	 * @param code the two-character ISO country code (case insensitive)
	 * @return the matching Country, or null if no country matches the code
	 */
	public Country getCountry(String code) {
		LOGGER.info("START");

		Country result = null;

		// Iterative approach
		for (Country country : countryList) {
			if (country.getCode().equalsIgnoreCase(code)) {
				result = country;
				break;
			}
		}

		// Equivalent lambda / stream approach (kept here for reference):
		// Optional<Country> match = countryList.stream()
		// 		.filter(country -> country.getCode().equalsIgnoreCase(code))
		// 		.findFirst();
		// result = match.orElse(null);

		LOGGER.debug("Country found for code {} : {}", code, result);
		LOGGER.info("END");
		return result;
	}

}
