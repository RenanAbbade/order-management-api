package com.restaurants.ordermanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.restaurants.ordermanagementapi.controller",
		"com.restaurants.ordermanagementapi.service"})
public class OrderManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApiApplication.class, args);
	}

}
