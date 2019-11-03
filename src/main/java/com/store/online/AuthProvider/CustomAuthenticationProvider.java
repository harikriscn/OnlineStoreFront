/**
 * 
 */
package com.store.online.AuthProvider;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author Harikrishnan
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		logger.debug("Authenticate user");
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		if ("user".equals(username) && "password".equals(password)) {
			logger.debug("Authentication Success");
			return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
		} else {
			logger.debug("Authentication failed");
			throw new BadCredentialsException("Authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
