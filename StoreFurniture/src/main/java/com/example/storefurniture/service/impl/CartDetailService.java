package com.example.storefurniture.service.impl;

import com.example.storefurniture.dto.UserDTO;
import com.example.storefurniture.entity.DetailCart;
import com.example.storefurniture.service.ICartDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartDetailService implements ICartDetailService {
    private final UserDTO userDTO;

    public CartDetailService(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public ResponseEntity save() {
        userDTO.getCart();
        System.out.println(userDTO.getCart());

        return null;
    }
}
