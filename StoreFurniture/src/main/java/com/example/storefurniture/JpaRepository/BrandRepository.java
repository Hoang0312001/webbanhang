package com.example.storefurniture.JpaRepository;

import com.example.storefurniture.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand findOneById(long id);
}
