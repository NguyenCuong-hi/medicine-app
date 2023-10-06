package com.example.medicineapp.dto.request;

import com.globits.core.dto.BaseObjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequestDto extends BaseObjectDto {
    private CartRequestDto cart;

    private String sku;

    private String price;

    private float discount;

    private Boolean isActive;

    private String content;
}
