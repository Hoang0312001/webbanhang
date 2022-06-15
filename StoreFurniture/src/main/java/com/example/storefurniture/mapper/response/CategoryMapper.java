package com.example.storefurniture.mapper.response;

import com.example.storefurniture.dto.Response.category.CategoryResponse;
import com.example.storefurniture.entity.Category;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface CategoryMapper extends mapper<Category, CategoryResponse> {
}