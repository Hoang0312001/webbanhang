package com.example.storefurniture.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category extends BaseInfor{
    @OneToMany(mappedBy = "category")
    private List<Product> product = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createBy")
    private User user;
}