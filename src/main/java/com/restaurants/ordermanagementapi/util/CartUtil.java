package com.restaurants.ordermanagementapi.util;

import com.restaurants.ordermanagementapi.model.ShoppingCart;
import jakarta.servlet.http.HttpSession;

public class CartUtil {

    public static ShoppingCart verifyCart(ShoppingCart cart, HttpSession session){
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}
