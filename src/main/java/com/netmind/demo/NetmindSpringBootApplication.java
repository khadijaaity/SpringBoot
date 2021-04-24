package com.netmind.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetmindSpringBootApplication {

	public final static Logger logger = LoggerFactory
			.getLogger(NetmindSpringBootApplication.class);

	public static void main(String[] args) {

		logger.info("My message before start application");
		SpringApplication.run(NetmindSpringBootApplication.class, args);
		logger.info("My message after start application");
	}

}
