package com.example.storefurniture.controller.api;

import com.example.storefurniture.dto.Request.product.ProductRequest;
import com.example.storefurniture.page.Pages;
import com.example.storefurniture.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
@GetMapping("getall")
    private ResponseEntity<Pages> findAll(@RequestBody Pages pages) {
            return productService.getAllProductByPage(pages);
        }
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequest productRequest){
         return  productService.save(productRequest);
    }

}
