package org.example.ex1.controller;

import org.example.ex1.dto.CartRequest;
import org.example.ex1.entity.CartItem;
import org.example.ex1.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public CartItem addToCart(
            @Valid @RequestBody CartRequest request
    ) {

        log.info("POST /api/cart/add");

        return cartService.addToCart(request);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(
            @PathVariable String userId
    ) {

        log.info("GET /api/cart/{}", userId);

        return cartService.getCartByUser(userId);
    }
}