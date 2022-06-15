package com.example.storefurniture.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
public class Cart extends BaseCommon{



    @Column
    private int totalNum;
    @Column
    private int totalPrice;

    @OneToMany(mappedBy = "cart")
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "cart")
    private List<DetailCart> detailCart = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;


}
