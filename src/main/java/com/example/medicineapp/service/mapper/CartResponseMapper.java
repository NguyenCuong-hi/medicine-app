package com.example.medicineapp.service.mapper;

import com.example.medicineapp.dto.response.CartItemResponseDto;
import com.example.medicineapp.dto.response.CartResponseDto;
import com.example.medicineapp.entity.CartEntity;
import com.example.medicineapp.entity.CartItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartResponseMapper {

    CartItemResponseDto map(CartItemEntity value);
    CartResponseDto entityToResponseDto(CartEntity entity);
}
