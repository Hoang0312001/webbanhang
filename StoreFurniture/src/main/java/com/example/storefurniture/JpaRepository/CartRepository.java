package com.example.storefurniture.JpaRepository;

import com.example.storefurniture.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findOneById(long id);

}
