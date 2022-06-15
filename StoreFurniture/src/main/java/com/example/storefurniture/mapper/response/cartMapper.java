package com.example.storefurniture.mapper.response;

import com.example.storefurniture.dto.Response.cart.CartResponse;
import com.example.storefurniture.entity.Cart;
import com.example.storefurniture.mapper.mapper;
@org.mapstruct.Mapper(componentModel = "spring")
public interface cartMapper extends mapper<Cart, CartResponse> {
}
