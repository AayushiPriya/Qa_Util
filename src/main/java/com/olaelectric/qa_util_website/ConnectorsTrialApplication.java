package com.olaelectric.qa_util_website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.olaelectric.qa_util_website.controller")
public class ConnectorsTrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectorsTrialApplication.class, args);
	}

}
