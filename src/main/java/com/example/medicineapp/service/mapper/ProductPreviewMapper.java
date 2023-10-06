package com.example.medicineapp.service.mapper;

import com.example.medicineapp.dto.request.ProductPreviewRequestDto;
import com.example.medicineapp.dto.response.ProductPreviewResponseDto;
import com.example.medicineapp.entity.ProductPreviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPreviewMapper {
    ProductPreviewResponseDto entityToResponseDto(ProductPreviewEntity dto);
}
