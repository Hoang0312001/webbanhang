package com.example.storefurniture.JpaRepository;

import com.example.storefurniture.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findOneById(long id);

}
