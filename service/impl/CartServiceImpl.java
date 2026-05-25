package org.example.ex1.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ex1.dto.CartRequest;
import org.example.ex1.entity.CartItem;
import org.example.ex1.repository.CartRepository;
import org.example.ex1.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public CartItem addToCart(CartRequest request){
        log.info("Add to cart request userId={}, productId={}, quantity={}",
        request.getUserId(),
        request.getQuantity());


        CartItem existingItem = cartRepository

                .findByUserIdAndProductId(

                        request.getUserId(),

                        request.getProductId()

                )

                .orElse(null);


        if(existingItem != null){
            existingItem.setQuantity(existingItem.getQuantity());
            log.info(

                    "Updated cart item productId={}, newQuantity={}",

                    existingItem.getProductId(),

                    existingItem.getQuantity()

            );

            return cartRepository.save(existingItem);
        }



        CartItem newItem = CartItem.builder()

                .userId(request.getUserId())

                .productId(request.getProductId())

                .quantity(request.getQuantity())

                .build();

        log.info(

                "Create new cart item userId={}, productId={}",

                request.getUserId(),

                request.getProductId()

        );

        return cartRepository.save(newItem);
    }

    @Override
    public List<CartItem> getCartByUser(String userId) {

        log.info("Get cart by userId={}", userId);

        return cartRepository.findByUserId(userId);

    }



}
