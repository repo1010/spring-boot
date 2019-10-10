package com.spring.springsecuritymysql.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.springsecuritymysql.model.MyUserDetails;
import com.spring.springsecuritymysql.model.User;
import com.spring.springsecuritymysql.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//creating a custom UserDetails entity
		//return new MyUserDetails(username);
		
		//creating UserDetails from user retriebved from DB
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+ username));
		
		return user.map(MyUserDetails::new).get();
	}

}
