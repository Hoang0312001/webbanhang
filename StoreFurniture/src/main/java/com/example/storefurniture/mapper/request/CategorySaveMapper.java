package com.example.storefurniture.mapper.request;

import com.example.storefurniture.dto.Request.category.CategoryRequest;
import com.example.storefurniture.entity.Category;
import com.example.storefurniture.mapper.mapper;

@org.mapstruct.Mapper(componentModel = "spring")
public interface CategorySaveMapper extends mapper<Category, CategoryRequest> {
}
