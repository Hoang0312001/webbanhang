package com.example.storefurniture.controller.api;

import com.example.storefurniture.Security.config.JwtTokenUtil;
import com.example.storefurniture.dto.Request.RequestJWT;
import com.example.storefurniture.dto.Request.user.UserSaveRequest;
import com.example.storefurniture.dto.Response.ResponseJWT;
import com.example.storefurniture.dto.UserDTO;
import com.example.storefurniture.service.impl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

@RestController
@RequestMapping("/auth")
public class JwtAuthenticationController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;




    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken (@RequestBody RequestJWT authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new ResponseJWT(token));
    }
    @PostMapping("/register")
    public ResponseEntity<?> SaveUser(@RequestBody UserSaveRequest userSaveRequest){
        return jwtUserDetailsService.saveUser(userSaveRequest);
//        System.out.println(userSaveRequest);
//        return null;
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
