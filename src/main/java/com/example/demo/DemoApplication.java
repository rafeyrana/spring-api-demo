package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @RestController // this makes the class to serve rest end points
// this whole application is a three tier architecture which is going to have an api layer, a service layer and then the data access layer for the db
// i will using this as documentation for the project
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	// for the restful endpoint we add
	
	

}
