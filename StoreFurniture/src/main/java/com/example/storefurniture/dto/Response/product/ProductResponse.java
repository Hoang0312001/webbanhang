package com.example.storefurniture.dto.Response.product;

import com.example.storefurniture.dto.AbtractInfor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductResponse extends AbtractInfor {
    private String name;
    private int price;
    private int priceSale;
    private int amount;
    private String code;
    private String description;
    private long id_brand;
    private long id_category;
    private List<Long> imageIds = new ArrayList<>();
}