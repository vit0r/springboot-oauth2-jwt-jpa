package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableAutoConfiguration
@EnableOAuth2Client
public class Oauth2JwtResourceApplication {
        
        public static void main(String[] args) {
		SpringApplication.run(Oauth2JwtResourceApplication.class, args);
	}
}
