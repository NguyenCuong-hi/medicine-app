package com.example.medicineapp.service;

import com.example.medicineapp.dto.request.CartItemRequestDto;
import com.example.medicineapp.dto.request.search.CartItemSearchDto;
import com.example.medicineapp.dto.response.CartItemResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface CartItemService {
    CartItemResponseDto getDtoById(UUID id);
    Page<CartItemResponseDto> searchBy(CartItemSearchDto searchDto);
    CartItemResponseDto createBy(CartItemRequestDto dto);
    CartItemResponseDto updateBy(UUID id, CartItemRequestDto dto);
    Boolean deleteBy(UUID id);
}
