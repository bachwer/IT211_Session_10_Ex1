package org.example.ex1.service;

import org.example.ex1.dto.CartRequest;
import org.example.ex1.entity.CartItem;

import java.util.List;

public interface CartService {

    CartItem addToCart(CartRequest request);

    List<CartItem> getCartByUser(String userId);
}
