package com.example.storefurniture.service.impl;

import com.example.storefurniture.Exception.JsonException;
import com.example.storefurniture.JpaRepository.CategoryRepository;
import com.example.storefurniture.dto.Request.category.CategoryRequest;
import com.example.storefurniture.dto.Response.category.CategoryResponse;
import com.example.storefurniture.dto.UserDTO;
import com.example.storefurniture.entity.Category;
import com.example.storefurniture.entity.User;
import com.example.storefurniture.mapper.request.CategorySaveMapper;
import com.example.storefurniture.mapper.response.CategoryMapper;
import com.example.storefurniture.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.storefurniture.constant.Constant.STATUS;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired JwtUserDetailsService userService;
    private final CategoryMapper categoryMapper;
    private final CategorySaveMapper categorySaveMapper;
    private final UserDTO userDTO;

    public CategoryService(CategoryMapper categoryMapper, CategorySaveMapper categorySaveMapper, UserDTO userDTO) {
        this.categoryMapper = categoryMapper;
        this.categorySaveMapper = categorySaveMapper;
        this.userDTO = userDTO;
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<CategoryResponse> categoryResponseList = categoryMapper.from(categoryRepository.findAll());
        return categoryResponseList;
    }

    @Override
    public CategoryResponse findOneById(long id) {
        CategoryResponse category = categoryMapper.from(categoryRepository.findOneById(id));
        return category;
    }

    @Override
    public ResponseEntity<?> save(CategoryRequest categoryRequest) {
        if (categoryRequest.getName() != null && categoryRequest.getCode() != null){
            Category category = categorySaveMapper.to(categoryRequest);
            User user = userService.findOneByUserName(userDTO.getUsername());
            category.setUser(user);
            category.setCode(STATUS);
            categoryRepository.save(category);
            return ResponseEntity.ok("Thêm thành công");
        }
        return new ResponseEntity<>(new JsonException(400,"Nhập đầy đủ thông tin"), HttpStatus.BAD_REQUEST);
    }
}
