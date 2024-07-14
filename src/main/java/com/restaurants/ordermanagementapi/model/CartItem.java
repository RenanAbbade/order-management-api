package com.restaurants.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItem {
    private Long productId;
    private String productName;
    private BigDecimal unitPrice;
    private String description;
    private int quantity;
}
