package com.example.storefurniture.service.impl;

import com.example.storefurniture.Exception.JsonException;
import com.example.storefurniture.JpaRepository.BrandRepository;
import com.example.storefurniture.dto.Request.brand.BrandRequest;
import com.example.storefurniture.dto.Response.Brand.BrandResponse;
import com.example.storefurniture.dto.UserDTO;
import com.example.storefurniture.entity.Brand;
import com.example.storefurniture.entity.User;
import com.example.storefurniture.mapper.request.BrandSaveMapper;
import com.example.storefurniture.mapper.response.BrandMapper;
import com.example.storefurniture.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.storefurniture.constant.Constant.STATUS;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private JwtUserDetailsService userService;
    private final BrandMapper brandMapper;
    private final BrandSaveMapper brandSaveMapper;
    private final UserDTO userDTO;


    public BrandService(BrandMapper brandMapper, BrandSaveMapper brandSaveMapper, UserDTO userDTO) {
        this.brandMapper = brandMapper;
        this.brandSaveMapper = brandSaveMapper;

        this.userDTO = userDTO;
    }

    @Override
    public List<BrandResponse> findAll() {
        List<BrandResponse> brandResponseList = brandMapper.from(brandRepository.findAll());
        return brandResponseList;
    }

    @Override
    public BrandResponse findOneById(long id) {
         BrandResponse brand = brandMapper.from(brandRepository.findOneById(id));
          return  brand;
    }

    @Override
    public ResponseEntity<?> save(BrandRequest brandRequest) {

         if (brandRequest.getName() != null && brandRequest.getCode() != null ){
             Brand brand = brandSaveMapper.to(brandRequest);
             User user = userService.findOneByUserName(userDTO.getUsername());
             brand.setUser(user);
             brand.setStatus(STATUS);
             brandRepository.save(brand);
             return ResponseEntity.ok("Thêm thành công");
         }
        return new ResponseEntity<>(new JsonException(400,"Nhập đầy đủ thông tin"),HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity update(long id,BrandRequest brandRequest) {

        if(brandRepository.findOneById(id) != null){
            Brand brand = brandSaveMapper.to(brandRequest);
            brand.setId(id);
            brandRepository.save(brand);
            return ResponseEntity.ok("Cap nhat thanh cong");
        }
        return new ResponseEntity(new JsonException(400,"Id không tồn tại"),HttpStatus.BAD_REQUEST);

    }
}
