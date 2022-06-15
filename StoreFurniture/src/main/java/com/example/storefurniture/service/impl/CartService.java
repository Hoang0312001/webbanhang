package com.example.storefurniture.service.impl;

import com.example.storefurniture.JpaRepository.CartRepository;
import com.example.storefurniture.dto.UserDTO;
import com.example.storefurniture.entity.Cart;
import com.example.storefurniture.entity.User;
import com.example.storefurniture.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;


    @Override
    public Void CreateCart(User user) {
        Cart cart   = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
        return null;
    }
}
