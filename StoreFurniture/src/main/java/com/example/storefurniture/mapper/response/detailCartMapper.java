package com.example.storefurniture.mapper.response;

import com.example.storefurniture.dto.Response.detailCart.DetailCartResponse;
import com.example.storefurniture.entity.DetailCart;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface detailCartMapper extends mapper<DetailCart, DetailCartResponse> {
}
