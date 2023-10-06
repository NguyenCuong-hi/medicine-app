package com.example.medicineapp.dto.response;

import com.globits.core.dto.BaseObjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CartResponseDto extends BaseObjectDto {
    private List<CartItemResponseDto> cartItems;

    private String status;

    private String content;

    private int quantity;

    private CustomersResponseDto customer;
}
