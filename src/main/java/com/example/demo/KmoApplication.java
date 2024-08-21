package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.example.controller")
@SpringBootApplication
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.Entity")
public class KmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmoApplication.class, args);
	}
}
