package com.java.api.console.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	// ENTRY POINT OF SPRING BOOT
	public static void main(String[] args) {
		System.out.println("Suraj");
		SpringApplication.run(DemoApplication.class, args);
	}

}
