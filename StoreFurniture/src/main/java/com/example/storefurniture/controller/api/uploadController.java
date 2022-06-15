package com.example.storefurniture.controller.api;

import com.example.storefurniture.service.impl.ImageService;
import com.example.storefurniture.service.impl.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class uploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/upload")
    private ResponseEntity<?> upload(@RequestParam (value = "file" , required = false) MultipartFile [] file ){
         return uploadService.upload(file);
       }
}
