/*package com.store.online.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.store.online.Service.UserDetailsServiceImpl;

*//**
 * @author Harikrishnan
 *
 *//*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

	
	 * @Autowired CustomAuthenticationProvider customAuthenticationProvider;
	 

	@Bean
	public UserDetailsService userDetailsService() {
		logger.debug("userDetailsService Bean created");
		return new UserDetailsServiceImpl();
	};

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		logger.debug("passwordEncoder Bean created");
		return new BCryptPasswordEncoder();
	};

	@Override
	public void configure(HttpSecurity http) throws Exception {
		logger.debug("configure role and httpsecurity for a user");
		http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER").and()
		.formLogin().and().logout().permitAll()
		.logoutSuccessUrl("/login").and().csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.debug("Authenticating user");
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

	}

}
*/