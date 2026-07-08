package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Week 3 JWT authentication service hands-on:
 *  - Step 1: AuthenticationController + SecurityConfig
 *  - Step 2: Decode username/password from the Authorization header
 *  - Step 3: Generate a JWT for the authenticated user
 *
 * Sample request once running:
 *   curl -s -u user:pwd http://localhost:8090/authenticate
 */
@SpringBootApplication
public class SpringLearnJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnJwtApplication.class, args);
	}

}
