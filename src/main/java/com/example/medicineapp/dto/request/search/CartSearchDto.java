package com.example.medicineapp.dto.request.search;

import com.example.medicineapp.dto.request.CartItemRequestDto;
import com.example.medicineapp.dto.request.CustomersRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartSearchDto extends SearchDto{
    private List<CartItemRequestDto> cartItems;

    private String status;

    private String content;

    private int quantity;

    private CustomersRequestDto customer;
}
