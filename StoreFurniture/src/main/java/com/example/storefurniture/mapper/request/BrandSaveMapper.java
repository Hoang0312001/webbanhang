package com.example.storefurniture.mapper.request;

import com.example.storefurniture.dto.Request.brand.BrandRequest;
import com.example.storefurniture.entity.Brand;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface BrandSaveMapper extends mapper<Brand, BrandRequest> {

}
