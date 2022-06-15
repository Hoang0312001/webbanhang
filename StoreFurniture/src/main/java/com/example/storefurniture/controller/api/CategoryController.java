package com.example.storefurniture.controller.api;

import com.example.storefurniture.dto.Request.category.CategoryRequest;
import com.example.storefurniture.dto.Response.category.CategoryResponse;
import com.example.storefurniture.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getall")
    private List<CategoryResponse> getAll(){
        return categoryService.findAll();
    }
    @PostMapping
    private ResponseEntity<?> saveCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.save(categoryRequest);
    }
}
