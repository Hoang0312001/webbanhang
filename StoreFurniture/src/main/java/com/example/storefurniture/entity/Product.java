package com.example.storefurniture.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product extends BaseInfor{
    @Column
    private int price;
    @Column
    private int priceSale;
    @Column
    private int amount;
    @Column (columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_brand")
    private Brand brand;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_image")
    private List<Image> Image = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<DetailOrder> DetailOrder = new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<DetailCart> DetailCart = new ArrayList<>();




}