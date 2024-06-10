package com.restaurants.ordermanagementapi.controller;

import com.restaurants.ordermanagementapi.model.Order;
import com.restaurants.ordermanagementapi.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id).dematerialize();
    }

    @PutMapping("/{id}")
    public Mono<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService .updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
