package com.example.storefurniture.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RequestJWT implements Serializable {
    private String username;
    private String password;
}
