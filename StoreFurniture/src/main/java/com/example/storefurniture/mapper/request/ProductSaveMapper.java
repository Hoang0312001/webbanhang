package com.example.storefurniture.mapper.request;

import com.example.storefurniture.dto.Request.product.ProductRequest;
import com.example.storefurniture.entity.Product;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface ProductSaveMapper extends mapper<Product,ProductRequest> {
}
