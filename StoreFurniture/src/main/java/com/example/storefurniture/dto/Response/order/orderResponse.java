package com.example.storefurniture.dto.Response.order;

import com.example.storefurniture.dto.AbtractCommon;
import lombok.Data;

import java.sql.Date;
@Data
public class orderResponse extends AbtractCommon {
    private Date dateConfirm;
    private String payment_method;
    private String code;
    private String note;
    private int totalNumProduct;
    private int totalPrice;


}