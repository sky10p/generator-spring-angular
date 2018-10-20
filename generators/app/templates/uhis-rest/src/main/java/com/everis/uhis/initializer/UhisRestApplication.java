package com.everis.uhis.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.everis.uhis" })
public class UhisRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UhisRestApplication.class, args);
	}
}
