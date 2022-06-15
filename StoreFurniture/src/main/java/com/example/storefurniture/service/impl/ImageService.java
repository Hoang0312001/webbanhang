package com.example.storefurniture.service.impl;

import com.example.storefurniture.JpaRepository.ImageRepository;
import com.example.storefurniture.dto.Request.image.ImageRequest;
import com.example.storefurniture.entity.Image;
import com.example.storefurniture.mapper.request.ImageSaveMapper;
import com.example.storefurniture.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ImageService implements IImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageSaveMapper imageSaveMapper;
    @Override
    public Image save(Image image) {
//        List<Image> imageArrayList = new ArrayList<>();
        Image imageList = imageRepository.save(image);
//        imageArrayList.add(imageList);
        return imageList;
    }

    @Override
    public Image findOneById(Long id) {
        return  imageRepository.findOneById(id);
    }

//    @Override
//    public Image findByLink(String link) {
//
//        return imageRepository.findByLink_image(link);
//    }
}
