package com.example.storefurniture.JpaRepository;

import com.example.storefurniture.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
  Image findOneById(Long id);
}
