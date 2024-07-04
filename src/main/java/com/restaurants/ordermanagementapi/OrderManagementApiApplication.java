package com.restaurants.ordermanagementapi;

import com.restaurants.ordermanagementapi.model.Order;
import com.restaurants.ordermanagementapi.model.Product;
import com.restaurants.ordermanagementapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class OrderManagementApiApplication implements CommandLineRunner {


	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Order order = Order.builder()
//				.id(null)
//				.customerName("Carol")
//				.tableNumber(7)
//				.build();
//		Product product = Product.builder()
//				.name("Pizza")
//				.description(" pizza madre")
//				.order(order)
//				.id(null)
//				.quantity(1)
//				.unitPrice(BigDecimal.TEN)
//				.build();
//		order.setProductList(List.of(product));
//
//		orderRepository.save(order);

	}
}
