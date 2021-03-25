package com.olaelectric.qa_util_website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan(basePackages = "com.olaelectric.qa_util_website")
@EnableAsync
public class ConnectorsTrialApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectorsTrialApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConnectorsTrialApplication.class, args);
	}

}
