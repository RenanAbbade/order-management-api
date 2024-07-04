package com.restaurants.ordermanagementapi.controller;

import com.restaurants.ordermanagementapi.model.CartItem;
import com.restaurants.ordermanagementapi.model.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import static com.restaurants.ordermanagementapi.util.CartUtil.verifyCart;

@RestController
@RequestMapping("/api/cart")
public class CartController {


    @GetMapping
    public ShoppingCart getCart(HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart = verifyCart(cart, session);
        return cart;
    }

    @PostMapping("/add")
    public ShoppingCart addItemToCart(@RequestBody CartItem item, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart = verifyCart(cart, session);
        cart.addItem(item);
        return cart;
    }

    @DeleteMapping("/remove/{productId}")
    public ShoppingCart removeItemFromCart(@PathVariable String productId, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart = verifyCart(cart, session);
        cart.removeItem(productId);
        return cart;
    }

    @DeleteMapping
    public void clearCart(HttpSession session) {
        session.removeAttribute("cart");
    }
}
