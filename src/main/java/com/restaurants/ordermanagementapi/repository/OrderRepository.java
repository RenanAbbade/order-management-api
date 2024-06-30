package com.restaurants.ordermanagementapi.repository;

import com.restaurants.ordermanagementapi.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    // Métodos de consulta personalizados conforme necessário
}

