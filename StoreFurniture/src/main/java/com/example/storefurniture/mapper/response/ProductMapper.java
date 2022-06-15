package com.example.storefurniture.mapper.response;

import com.example.storefurniture.dto.Response.product.ProductResponse;
import com.example.storefurniture.entity.Product;
import com.example.storefurniture.mapper.mapper;

@org.mapstruct.Mapper(componentModel = "spring")
public interface ProductMapper extends mapper<Product, ProductResponse> {

}