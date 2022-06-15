package com.example.storefurniture.entity;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User extends BaseCommon{

    @Column(unique = true, columnDefinition = "varchar(255)")
    private String username;
    @Column(columnDefinition = "nvarchar(255)")
    private String password;
    @Column(columnDefinition = "nvarchar(255)")
    private String fullName;
    @Column(columnDefinition = "nvarchar(255)")
    private  String mail;
    @Column(columnDefinition = "nvarchar(255)")
    private String phone;
    @Column(columnDefinition = "nvarchar(300)")
    private String address;
    @Column(columnDefinition = "int(11)")
    private int role;
    @Column(columnDefinition = "nvarchar(255)")
    private int activity;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Category>  category  = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Brand>  brand  = new ArrayList<>();


}