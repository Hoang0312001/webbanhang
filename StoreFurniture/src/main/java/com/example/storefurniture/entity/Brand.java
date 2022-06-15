package com.example.storefurniture.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Brand extends BaseInfor{
    //    CREATE TABLE `Brand` (
//            `id` int(11) NOT NULL,
//  `name` varchar(255) NOT NULL,
//  `code` varchar(255) NOT NULL,
//  `User` varchar(255) NOT NULL,
//  `activity_brand` int(11) NOT NULL
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    @OneToMany(mappedBy = "brand")
    private List<Product> product = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createBy")
    private User user;
}