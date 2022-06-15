package com.example.storefurniture.dto.Response.cart;

import com.example.storefurniture.dto.AbtractInfor;
import lombok.Data;

@Data
public class CartResponse extends AbtractInfor {
    private int totalNum;
    private int totalPrice;
}
