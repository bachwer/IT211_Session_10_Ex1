package org.example.ex1.repository;

import org.example.ex1.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByUserIdAndProductId(
            String userId,
            String productId);

    List<CartItem> findByUserId(String userId);
}