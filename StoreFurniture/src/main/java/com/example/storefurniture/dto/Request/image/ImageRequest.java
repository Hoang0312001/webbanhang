package com.example.storefurniture.dto.Request.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ImageRequest {

    @JsonProperty("link_image")
    private String link_image;

}
