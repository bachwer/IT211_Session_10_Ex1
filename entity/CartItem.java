package org.example.ex1.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "user_id", nullable = false)

    private String userId;

    @Column(name = "product_id", nullable = false)

    private String productId;

    @Column(nullable = false)

    private Integer quantity;

}
