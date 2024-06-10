package com.restaurants.ordermanagementapi.repository;

import com.restaurants.ordermanagementapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Métodos de consulta personalizados conforme necessário
}

