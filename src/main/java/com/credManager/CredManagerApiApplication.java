package com.credManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CredManagerApiApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CredManagerApiApplication.class, args);
	}

}
