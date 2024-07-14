package com.restaurants.ordermanagementapi.mapper;

import com.restaurants.ordermanagementapi.model.CartItem;
import com.restaurants.ordermanagementapi.model.Order;
import com.restaurants.ordermanagementapi.model.Product;
import com.restaurants.ordermanagementapi.model.ShoppingCart;

import java.util.HashSet;
import java.util.Set;

public class CartToOrderMapper {

    public static Order map(Order order, ShoppingCart shoppingCart){
        Set<CartItem> items = shoppingCart.getItems();
        Set<Product> productSet = new HashSet<>();
        items.forEach(cartItem -> {
            productSet.add(Product.builder()
                    .name(cartItem.getProductName())
                    .description(cartItem.getDescription())
                    .quantity(cartItem.getQuantity())
                    .unitPrice(cartItem.getUnitPrice())
                    .build());

        });
        order.setProductList(productSet);
        return order;
    }
}
