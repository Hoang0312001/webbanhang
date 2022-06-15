package com.example.storefurniture.service.impl;

import com.example.storefurniture.Exception.JsonException;
import com.example.storefurniture.JpaRepository.UserRepository;
import com.example.storefurniture.constant.Constant;
import com.example.storefurniture.dto.Request.user.UserSaveRequest;
import com.example.storefurniture.dto.UserDTO;
import com.example.storefurniture.mapper.request.UserSaveMapper;
import com.example.storefurniture.mapper.request.UserSaveMapperImpl;
import com.example.storefurniture.service.IJwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.storefurniture.constant.Constant.ACTIVITY;
import static com.example.storefurniture.constant.Constant.ROLE;

@Service
public class JwtUserDetailsService implements UserDetailsService, IJwtUserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private UserSaveMapper userSaveMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CartService cartService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       com.example.storefurniture.entity.User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new User(username,user.getPassword(),new ArrayList<>());

    }



    @Override
    public UserDTO save(UserDTO userDTO) {
        com.example.storefurniture.entity.User user = new com.example.storefurniture.entity.User();
        user.setUsername(userDTO.getUsername());
//        user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));;
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public ResponseEntity saveUser(UserSaveRequest userSaveRequest) {
        if (userSaveRequest.getUsername().length() > 4 && userSaveRequest.getPassword().length() > 4){
            com.example.storefurniture.entity.User user = userSaveMapper.to(userSaveRequest);
            String password = BCrypt.hashpw(userSaveRequest.getPassword(), BCrypt.gensalt(12));
            user.setPassword(password);
            user.setRole(ROLE);
            user.setActivity(ACTIVITY);
             com.example.storefurniture.entity.User userInf =  userRepository.save(user);
             cartService.CreateCart(userInf);
            return ResponseEntity.ok("Đăng ký thành công");
        }

        return new ResponseEntity<>(new JsonException(400,"Mật khẩu trên 4 ký tự và tài khoản trên 4 ký tự"), HttpStatus.BAD_REQUEST);
    }

    @Override
    public com.example.storefurniture.entity.User findOneByUserName(String username) {
        return userRepository.findOneByUsername(username);
    }


}

