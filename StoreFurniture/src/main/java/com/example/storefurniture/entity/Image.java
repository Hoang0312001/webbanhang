package com.example.storefurniture.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Image extends BaseCommon{
    @Column(columnDefinition = "text")
    private String link_image;
    @ManyToMany(mappedBy =  "Image")
    private List<Product> products = new ArrayList<>();
}
