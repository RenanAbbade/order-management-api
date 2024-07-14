package com.restaurants.ordermanagementapi.controller;

import com.restaurants.ordermanagementapi.model.CartItem;
import com.restaurants.ordermanagementapi.model.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static com.restaurants.ordermanagementapi.util.CartUtil.verifyCart;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final Logger logger = Logger.getLogger(CartController.class.getName());

    @GetMapping
    public ShoppingCart getCart(HttpSession session) {
        logger.info("Verifying items of cart");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart = verifyCart(cart, session);
        return cart;
    }

    @PostMapping("/add")
    public ShoppingCart addItemToCart(@RequestBody CartItem item, HttpSession session) {
        logger.info("Adding items to the cart");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart = verifyCart(cart, session);
        cart.addItem(item);
        return cart;
    }

    @DeleteMapping("/remove/{productId}")
    public ShoppingCart removeItemFromCart(@PathVariable String productId, HttpSession session) {
        logger.info("Remove items to the cart");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        cart = verifyCart(cart, session);
        cart.removeItem(productId);
        return cart;
    }

    @DeleteMapping
    public void clearCart(HttpSession session) {
        logger.info("Remove all items to the cart");
        session.removeAttribute("cart");
    }
}
