package com.example.storefurniture.dto.Response.detailOrder;

import com.example.storefurniture.dto.AbtractCommon;
import lombok.Data;

@Data
public class DetailOrderResponse extends AbtractCommon {
    private int subTotalPrice;
    private int numTotal;
}
