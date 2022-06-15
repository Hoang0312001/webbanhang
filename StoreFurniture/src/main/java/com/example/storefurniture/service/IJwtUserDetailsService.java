package com.example.storefurniture.service;

import com.example.storefurniture.dto.Request.user.UserSaveRequest;
import com.example.storefurniture.dto.UserDTO;
import com.example.storefurniture.entity.User;
import com.example.storefurniture.mapper.request.UserSaveMapper;
import org.springframework.http.ResponseEntity;

public interface IJwtUserDetailsService {
    UserDTO save(UserDTO userDTO);
   ResponseEntity<?> saveUser(UserSaveRequest userSaveRequest);
   User findOneByUserName(String username);
}
