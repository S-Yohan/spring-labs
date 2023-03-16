package com.revature.L3_fitness;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @SpringBootApplication annotation enables automatic configuration of a Spring App.
 */
@SpringBootApplication
public class FitnessApplication {
	/**
	 * Logger setup
	 */
	public static Logger log = LogManager.getLogger();

	/**
	 * SpringApplication.run will set up the Spring ArtApplication Context for us and start up all controllers
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FitnessApplication.class);
	}

}