package com.example.storefurniture.controller.api;

import com.example.storefurniture.dto.Request.brand.BrandRequest;
import com.example.storefurniture.dto.Response.Brand.BrandResponse;
import com.example.storefurniture.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/getall")
    private List<BrandResponse> findAll(){
        return brandService.findAll();
    }
    @PostMapping
    private ResponseEntity<?> saveBrand(@RequestBody BrandRequest brandRequest){
        return brandService.save(brandRequest);
    }
    @PutMapping("/update/{id}")
    private ResponseEntity update(@PathVariable ("id") long id, @RequestBody BrandRequest brandRequest){
       return brandService.update(id,brandRequest);
    }
}
