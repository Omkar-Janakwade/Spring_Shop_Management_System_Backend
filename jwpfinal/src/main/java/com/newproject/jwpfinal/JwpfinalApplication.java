package com.newproject.jwpfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.newproject.Entity")
public class JwpfinalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JwpfinalApplication.class, args);
		System.out.println("welcome");
	}

}	
 