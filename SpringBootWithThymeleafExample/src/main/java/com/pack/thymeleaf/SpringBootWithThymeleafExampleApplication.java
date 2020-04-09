package com.pack.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"controller"})
@SpringBootApplication
public class SpringBootWithThymeleafExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithThymeleafExampleApplication.class, args);
	}
}
