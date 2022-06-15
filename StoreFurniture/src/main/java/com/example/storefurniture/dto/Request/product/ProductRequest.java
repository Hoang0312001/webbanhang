package com.example.storefurniture.dto.Request.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductRequest {
    private String name;
    private int price;
    private int priceSale;
    private int amount;
    private String code;
    private String description;
    @JsonProperty("brand")
    private long id_brand;
    @JsonProperty("category")
    private long id_category;
    @JsonProperty("Image")
    private List<Long> imageIds = new ArrayList<>();
}
