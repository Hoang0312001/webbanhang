package com.example.storefurniture.dto.Response.image;

import com.example.storefurniture.dto.AbtractCommon;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ImageResponse  {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("link_image")
    private String link_image;
}
