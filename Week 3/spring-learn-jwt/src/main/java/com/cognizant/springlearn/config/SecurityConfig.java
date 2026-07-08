package com.cognizant.springlearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Hands on Step 1: Create authentication controller and configure it in
 * SecurityConfig.
 *
 * - Defines the "user"/"pwd" credential used in the sample curl command
 *   (curl -u user:pwd ...).
 * - /authenticate is permitted at the filter-chain level. The credential
 *   check itself is done inside AuthenticationController (Step 2 and
 *   Step 3), using the AuthenticationManager bean exposed here, rather
 *   than Spring Security's automatic HTTP Basic filter. This lets the
 *   controller read and decode the Authorization header itself.
 * - Every other endpoint still requires a valid request to pass through
 *   Spring Security, and the app is configured as stateless since JWT
 *   (not a server session) will carry the identity of the caller on
 *   subsequent requests.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
	 * In-memory user store containing the "user" / "pwd" credentials used
	 * by the sample curl command.
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("pwd"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Exposes an AuthenticationManager bean so AuthenticationController can
	 * validate the decoded username/password against userDetailsService().
	 */
	@Bean
	public AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider::authenticate;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeHttpRequests()
				.antMatchers("/authenticate").permitAll()
				.anyRequest().authenticated();
		return http.build();
	}

}
