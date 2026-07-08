package com.cognizant.springlearn.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * Hands on Step 3: Generate token based on the user retrieved in the
 * previous step.
 *
 * Builds a signed JWT (HS256) whose subject is the authenticated username,
 * with an issued-at and expiry claim - the same shape as the token shown
 * in the sample response.
 */
@Component
public class JwtUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

	// NOTE: for a real application, load this from a secure external
	// property (e.g. an environment variable), never hard-code it.
	private static final String SECRET_KEY =
			"ThisIsADemoSecretKeyForHS256SigningUseAPropertyInRealApps";

	// Token validity: 20 minutes, matching the ~1200 second (exp - iat)
	// window seen in the sample token in the hands-on.
	private static final long EXPIRATION_MS = 1000 * 60 * 20;

	/**
	 * Generates a signed JWT for the given username.
	 */
	public String generateToken(String username) {
		LOGGER.info("START");

		Map<String, Object> claims = new HashMap<>();
		String token = createToken(claims, username);

		LOGGER.debug("Generated token for user {} : {}", username, token);
		LOGGER.info("END");
		return token;
	}

	private String createToken(Map<String, Object> claims, String subject) {
		Date now = new Date(System.currentTimeMillis());
		Date expiry = new Date(now.getTime() + EXPIRATION_MS);

		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(now)
				.setExpiration(expiry)
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getSignInKey() {
		byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
