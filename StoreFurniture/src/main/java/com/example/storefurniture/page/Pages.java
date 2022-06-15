package com.example.storefurniture.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Pages<T> {
    private int page;
    private int limit;
    private int totalPage;
    private List<T> listResult = new ArrayList<>();
}
