package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.AuthenticationResponse;
import com.cognizant.springlearn.util.JwtUtil;

/**
 * Authentication service that returns a JWT.
 *
 * GET http://localhost:8090/authenticate    (credentials sent via -u, i.e.
 * an HTTP Basic "Authorization" header)
 *
 * Response: {"token":"..."}
 */
@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	private static final String BASIC_PREFIX = "Basic ";

	// Hands on Step 1: AuthenticationManager bean is wired in from
	// SecurityConfig and used below to validate the decoded credentials.
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/authenticate")
	public ResponseEntity<?> authenticate(
			@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {

		LOGGER.info("START");

		if (authorizationHeader == null || !authorizationHeader.startsWith(BASIC_PREFIX)) {
			LOGGER.debug("Authorization header missing or not HTTP Basic - rejecting request");
			LOGGER.info("END");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("Authorization header with Basic credentials is required");
		}

		// Hands on Step 2: Read Authorization header and decode the
		// username and password.
		// curl's -u user:pwd option sends "Authorization: Basic <base64 of user:pwd>"
		String base64Credentials = authorizationHeader.substring(BASIC_PREFIX.length()).trim();
		byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
		String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

		// credentials is now "username:password"
		String[] values = credentials.split(":", 2);
		String username = values[0];
		String password = values.length > 1 ? values[1] : "";

		LOGGER.debug("Decoded username from Authorization header: {}", username);

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException ex) {
			LOGGER.debug("Invalid credentials supplied for username: {}", username);
			LOGGER.info("END");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("Incorrect username or password");
		}

		// Hands on Step 3: Generate token based on the user retrieved above.
		String token = jwtUtil.generateToken(username);

		LOGGER.info("END");
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}

}
