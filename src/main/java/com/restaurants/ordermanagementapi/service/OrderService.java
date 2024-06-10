package com.restaurants.ordermanagementapi.service;

import com.restaurants.ordermanagementapi.model.Order;
import com.restaurants.ordermanagementapi.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<Order> createOrder(Order order) {
        // Lógica para salvar o pedido no banco de dados
        return Mono.just(orderRepository.save(order));
    }

    public  Mono<Optional<Order>> getOrderById(Long id) {
        // Lógica para buscar o pedido por ID
        return Mono.just(orderRepository.findById(id));
    }

    public  Mono<Order> updateOrder(Long id, Order order) {
        // Lógica para atualizar o pedido
        return Mono.just(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        // Lógica para excluir o pedido
        orderRepository.deleteById(id);
    }
}

