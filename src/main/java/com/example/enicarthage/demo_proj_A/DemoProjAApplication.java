package com.example.enicarthage.demo_proj_A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoProjAApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjAApplication.class, args);
	}
	@GetMapping
	public String hello() {
		return "Hello World";
	}
}
