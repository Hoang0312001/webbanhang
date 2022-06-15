package com.example.storefurniture.service;

import com.example.storefurniture.dto.Request.category.CategoryRequest;
import com.example.storefurniture.dto.Response.category.CategoryResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> findAll();
    CategoryResponse findOneById(long id);
    ResponseEntity<?> save(CategoryRequest categoryRequest);
}
