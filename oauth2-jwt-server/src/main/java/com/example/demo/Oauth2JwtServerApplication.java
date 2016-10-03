package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Oauth2JwtServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2JwtServerApplication.class, args);
	}
}
