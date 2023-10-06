package com.example.medicineapp.dto.request;

import com.example.medicineapp.entity.CartItemEntity;
import com.example.medicineapp.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CartRequestDto {
    private List<CartItemRequestDto> cartItems;

    private String status;

    private String content;

    private int quantity;

    private CustomersRequestDto customer;

}
