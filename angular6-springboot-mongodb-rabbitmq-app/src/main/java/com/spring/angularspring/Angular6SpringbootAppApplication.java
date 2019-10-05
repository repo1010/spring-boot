package com.spring.angularspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Angular6SpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Angular6SpringbootAppApplication.class, args);
	}

}
