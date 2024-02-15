package com.example.withoutdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WithoutdbApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WithoutdbApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WithoutdbApplication.class);
	}
}
