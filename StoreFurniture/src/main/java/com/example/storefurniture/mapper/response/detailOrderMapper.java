package com.example.storefurniture.mapper.response;

import com.example.storefurniture.dto.Response.detailOrder.DetailOrderResponse;
import com.example.storefurniture.entity.DetailOrder;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface detailOrderMapper extends mapper<DetailOrder, DetailOrderResponse> {
}