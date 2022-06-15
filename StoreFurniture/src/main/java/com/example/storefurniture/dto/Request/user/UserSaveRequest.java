package com.example.storefurniture.dto.Request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class UserSaveRequest {
    private String username;
    private String password;
    private String address;
    private String mail;
    private String phone;
    private String fullName;
}
