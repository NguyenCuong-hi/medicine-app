package com.example.medicineapp.dto.request.search;

import com.example.medicineapp.dto.request.CartRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemSearchDto extends SearchDto{
    private CartRequestDto cart;

    private String sku;

    private String price;

    private float discount;

    private Boolean isActive;

    private String content;
}
