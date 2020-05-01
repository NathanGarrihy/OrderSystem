package com.sales.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}

	// configuration of login functionality
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Code to authenticate user
		http.authorizeRequests()
				.antMatchers("/addCustomer.html", "/addOrder.html", "/addProduct.html", "/showCustomers.html",
						"/showOrders.html", "/showProducts.html")
				.hasRole("USER").and().formLogin().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index.html");

	}
}