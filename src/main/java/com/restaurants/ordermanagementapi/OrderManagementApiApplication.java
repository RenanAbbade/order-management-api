package com.restaurants.ordermanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.restaurants.ordermanagementapi.repository")
@ComponentScan(basePackages = {
		"com.restaurants.ordermanagementapi.controller",
		"com.restaurants.ordermanagementapi.service",
		"com.restaurants.ordermanagementapi.repository"})
public class OrderManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApiApplication.class, args);
	}

}
