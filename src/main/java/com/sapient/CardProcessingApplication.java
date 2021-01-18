package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.controller.CardProcessController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.controller", "com.*"})
public class CardProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardProcessingApplication.class, args);
	}

}
