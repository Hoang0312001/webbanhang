package com.example.storefurniture.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class AbtractInfor<T> {
    private Long id;
    @JsonProperty("createdDate")
    private Date createdDate;
    private String name;
    private String code;
    private String status;
}
