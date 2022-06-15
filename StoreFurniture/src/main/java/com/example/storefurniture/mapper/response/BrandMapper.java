package com.example.storefurniture.mapper.response;

import com.example.storefurniture.dto.Response.Brand.BrandResponse;
import com.example.storefurniture.entity.Brand;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface BrandMapper extends mapper<Brand, BrandResponse> {
}
