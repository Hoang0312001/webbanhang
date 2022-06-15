package com.example.storefurniture.service;

import com.example.storefurniture.entity.Image;

import java.util.List;
import java.util.Optional;

public interface IImageService {
    Image save(Image image);
    Image findOneById(Long id);

//    Image findByLink(String link);
}
