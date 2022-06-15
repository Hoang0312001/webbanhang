package com.example.storefurniture.mapper.response;

import com.example.storefurniture.dto.Response.order.orderResponse;
import com.example.storefurniture.entity.Orders;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface orderMapper extends mapper<Orders, orderResponse> {
}