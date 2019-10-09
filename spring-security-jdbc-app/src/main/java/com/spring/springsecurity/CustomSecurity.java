package com.spring.springsecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class CustomSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//With Deafult Schema and hardcode dataset
		/*
		 * auth.jdbcAuthentication() .dataSource(dataSource) .withDefaultSchema()
		 * .withUser(User.withUsername("user").password("pass").roles("USER"))
		 * .withUser(User.withUsername("admin").password("pass").roles("ADMIN"));
		 */
		
		//default datasource and define schema and data in file
		auth.jdbcAuthentication() .dataSource(dataSource) ;
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin()
		.and().logout();
	}
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
}
