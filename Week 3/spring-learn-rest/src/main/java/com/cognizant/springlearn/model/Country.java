package com.cognizant.springlearn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Country - two-character ISO code and name.
 * Instances of this class are converted automatically to JSON by Jackson
 * (bundled with spring-boot-starter-web) whenever a controller method
 * returns it directly.
 */
public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	private String code;
	private String name;

	public Country() {
		LOGGER.debug("Inside Country Constructor.");
	}

	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		LOGGER.debug("Inside getCode()");
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("Inside setCode() : {}", code);
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside getName()");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside setName() : {}", name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
