package com.evaluator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This calss is reponsibel for starting and configruing the embedded tomcat
 * server
 * 
 * @author Jagan
 * @version 1.0
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
