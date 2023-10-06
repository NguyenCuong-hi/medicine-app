package com.example.medicineapp.service.mapper;

import com.example.medicineapp.dto.response.CategoryResponseDto;
import com.example.medicineapp.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {
    CategoryResponseDto entityToRespone (CategoryEntity entity);
}
