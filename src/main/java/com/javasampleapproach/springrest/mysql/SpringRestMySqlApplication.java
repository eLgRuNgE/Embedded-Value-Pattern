package com.javasampleapproach.springrest.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.springrest.mysql.repo.CustomerRepository;

@SpringBootApplication
public class SpringRestMySqlApplication {
	
	@Autowired
	static CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestMySqlApplication.class, args);
	}
}
