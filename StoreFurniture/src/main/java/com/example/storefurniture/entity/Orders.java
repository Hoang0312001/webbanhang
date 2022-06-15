package com.example.storefurniture.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Orders extends BaseCommon {

    @Column
    private int totalPrice;
    @Column
    private int totalNumProduct;
    @Column(columnDefinition = "text")
    private String note;
    @Column
    private String code;
    @Column
    private String payment_method;
    @Column(updatable  = false)
    @CreationTimestamp
    private Date dateConfirm;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "orders")
    private List<DetailOrder> detailOrder = new ArrayList<>();

}
