package com.netmind.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netmind.demo.NetmindSpringBootApplication;
import com.netmind.demo.config.DatabaseConfig;

@RestController
public class HelloWorldController {

	public final Logger logger = LoggerFactory
			.getLogger(NetmindSpringBootApplication.class);

	@Autowired
	private DatabaseConfig DatabaseConfig;

	@RequestMapping("/")
	String home() {
		logger.info(DatabaseConfig.getUrl());
		return DatabaseConfig.devDatabaseConnection();
	}

}
