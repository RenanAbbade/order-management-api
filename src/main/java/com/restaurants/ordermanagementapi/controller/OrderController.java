package com.restaurants.ordermanagementapi.controller;

import com.restaurants.ordermanagementapi.mapper.CartToOrderMapper;
import com.restaurants.ordermanagementapi.model.Order;
import com.restaurants.ordermanagementapi.model.ShoppingCart;
import com.restaurants.ordermanagementapi.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final Logger logger = Logger.getLogger(OrderController.class.getName());

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order, HttpSession session) {
        logger.info("Creating order based on the cart");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        CartToOrderMapper.map(order, cart);
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        logger.info("Getting order by id ".concat(String.valueOf(id)));
        Order foundOrder = orderService.getOrderById(id);
        return foundOrder != null
                ? ResponseEntity.ok(foundOrder)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        logger.info("Updating order by id ".concat(String.valueOf(id)));
        Order updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        logger.info("Deleting order by id ".concat(String.valueOf(id)));
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
