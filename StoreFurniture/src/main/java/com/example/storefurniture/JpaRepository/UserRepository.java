package com.example.storefurniture.JpaRepository;

import com.example.storefurniture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findOneByUsername(String name);
}