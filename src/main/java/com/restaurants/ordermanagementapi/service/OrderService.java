package com.restaurants.ordermanagementapi.service;

import com.restaurants.ordermanagementapi.model.Order;
import com.restaurants.ordermanagementapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        // Lógica para salvar o pedido no banco de dados
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        // Lógica para buscar o pedido por ID
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order order) {
        // Lógica para atualizar o pedido
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        // Lógica para excluir o pedido
        orderRepository.deleteById(id);
    }
}
