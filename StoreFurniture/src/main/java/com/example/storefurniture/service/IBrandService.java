package com.example.storefurniture.service;

import com.example.storefurniture.dto.Request.brand.BrandRequest;
import com.example.storefurniture.dto.Request.product.ProductRequest;
import com.example.storefurniture.dto.Response.Brand.BrandResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBrandService {
    List<BrandResponse> findAll();
    BrandResponse findOneById(long id);
    ResponseEntity<?> save(BrandRequest brandRequest);
    ResponseEntity update(long id,BrandRequest brandRequest);
}
