package com.example.storefurniture.dto.Response.detailCart;

import com.example.storefurniture.dto.AbtractCommon;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailCartResponse extends AbtractCommon {
    private int subTotalPrice;
    private int numTotal;
    private int idUser;
    private int idProduct;
}