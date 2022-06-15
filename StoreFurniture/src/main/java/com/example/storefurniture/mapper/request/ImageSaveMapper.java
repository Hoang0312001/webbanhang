package com.example.storefurniture.mapper.request;

import com.example.storefurniture.dto.Request.image.ImageRequest;
import com.example.storefurniture.entity.Image;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface ImageSaveMapper extends mapper<Image, ImageRequest> {

}
