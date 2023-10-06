package com.example.medicineapp.dto.response;

import com.example.medicineapp.entity.CartEntity;


public class CartItemResponseDto {

    private CartEntity cart;

    private String sku;

    private String price;

    private float discount;

    private Boolean isActive;

    private String content;
}
