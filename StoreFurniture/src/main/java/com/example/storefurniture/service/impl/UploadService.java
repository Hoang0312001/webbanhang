package com.example.storefurniture.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.storefurniture.Exception.JsonException;
import com.example.storefurniture.dto.Request.image.ImageRequest;
import com.example.storefurniture.dto.Response.image.ImageResponse;
import com.example.storefurniture.entity.Image;
import com.example.storefurniture.entity.Product;
import com.example.storefurniture.mapper.request.ImageSaveMapper;
import com.example.storefurniture.service.IImageService;
import com.example.storefurniture.service.IUploadService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
@AllArgsConstructor
public class UploadService implements IUploadService {
    private final Cloudinary cloudinary;
    private final IImageService iImageService;
    @Autowired
    private ImageSaveMapper imageSaveMapper;


    @Override
    public ResponseEntity<?> upload(MultipartFile[] files) {
        List<ImageResponse> imageRequestList = new ArrayList<>();
        if (files.length <= 5){
            for (MultipartFile file : files){
            ImageResponse imageResponse = getImage(file);
                if (imageResponse != null){
                   imageRequestList.add(imageResponse);

                }
                return ResponseEntity.ok(imageResponse);
            }
        }
        return new ResponseEntity<>(new JsonException(400,"Upload tối đa 7 ảnh"), HttpStatus.BAD_REQUEST);
    }

    private ImageResponse getImage(MultipartFile file) {
        try {
            String formatFile = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
            if (formatFile.equals("jpg") || formatFile.equals("png")) {
                Map result = cloudinary.uploader().upload(file.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String link = (String) result.get("secure_url");
                Image images = new Image();
                images.setLink_image(link);
                ImageResponse imageResponse = new ImageResponse();

                     Image image =  iImageService.save(images);
//
                       imageResponse.setLink_image(image.getLink_image());
                       imageResponse.setId(image.getId());

                return  imageResponse;

            }
            return null;
        } catch (IOException e) {
            return null;
        }

    }
}
