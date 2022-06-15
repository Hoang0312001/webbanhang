package com.example.storefurniture.dto;

import com.example.storefurniture.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Service
public class UserDTO extends AbtractCommon{


    private String username;
    private String password;
    private String phone;
    private String address;
    private int activity;
    private  String mail;
    private String fullName;
    private Cart cart;
}
