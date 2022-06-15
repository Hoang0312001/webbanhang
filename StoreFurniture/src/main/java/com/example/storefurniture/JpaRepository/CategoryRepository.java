package com.example.storefurniture.JpaRepository;

import com.example.storefurniture.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findOneById(long id);
}
