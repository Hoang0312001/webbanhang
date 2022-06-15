package com.example.storefurniture.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DetailOrder extends BaseCommon{
    //  `id` int(11) NOT NULL,
//  `id_order` int(11) NOT NULL,
//  `id_product` int(11) NOT NULL,
//  `qty` int(11) NOT NULL,
//  `sub_total_price` float NOT NULL
    @Column
    private int amount;
    @Column
    private int subTotalPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order")
    private Orders orders;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;


}