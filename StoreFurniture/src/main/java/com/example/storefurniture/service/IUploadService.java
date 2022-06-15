package com.example.storefurniture.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {
    ResponseEntity<?> upload(MultipartFile[] files);
}