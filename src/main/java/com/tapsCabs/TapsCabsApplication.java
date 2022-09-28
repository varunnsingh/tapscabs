package com.tapsCabs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @implNote TapsCabs - application for booking taxi
 */
@SpringBootApplication
public class TapsCabsApplication {
	private static final Logger log = LoggerFactory.getLogger(TapsCabsApplication.class);
	public static void main(String[] args) {

		log.info("I am in main class");
		SpringApplication.run(TapsCabsApplication.class, args);
	}

}
