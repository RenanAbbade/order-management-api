package com.restaurants.ordermanagementapi.service;

import com.restaurants.ordermanagementapi.model.Order;
import com.restaurants.ordermanagementapi.model.Product;
import com.restaurants.ordermanagementapi.repository.OrderRepository;
import com.restaurants.ordermanagementapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createOrder(Order order) {
        order.setTotalPrice(order.calculateTotalPrice());
        return orderRepository.save(order);
    }


    public Order getOrderById(Long id) {
        // Lógica para buscar o pedido por ID
        return orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public Order updateOrder(Long id, Order order) {
        // Lógica para atualizar o pedido
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        // Lógica para excluir o pedido
        orderRepository.deleteById(id);
    }
}
