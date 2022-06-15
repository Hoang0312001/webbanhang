package com.example.storefurniture.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class DetailCart extends BaseCommon {
    //    num_total`, `sub_total_price
    @Column
    private int numTotal;
    @Column
    private int subTotalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cart")
    private Cart cart;


}