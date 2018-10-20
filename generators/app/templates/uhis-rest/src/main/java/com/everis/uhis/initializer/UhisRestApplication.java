package com.everis.<%= appName %>.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.everis.<%= appName %>" })
public class <%= appName_CamelCase %>RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(<%= appName_CamelCase %>RestApplication.class, args);
	}
}
