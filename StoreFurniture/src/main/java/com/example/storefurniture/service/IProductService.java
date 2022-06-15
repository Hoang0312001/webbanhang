package com.example.storefurniture.service;

import com.example.storefurniture.dto.Request.product.ProductRequest;
import com.example.storefurniture.dto.Response.product.ProductResponse;
import com.example.storefurniture.page.Pages;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
//   List<ProductResponse> findAll(Pageable pageable);
ResponseEntity<Pages> getAllProductByPage(Pages pages);
   ResponseEntity<?> save(ProductRequest productRequest);
   ResponseEntity<?> deleteByID(long ids []);
   int totalPage();

}
