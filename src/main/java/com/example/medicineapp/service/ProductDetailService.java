package com.example.medicineapp.service;

import com.example.medicineapp.dto.request.ProductDetailRequestDto;
import com.example.medicineapp.dto.request.search.ProductDetailSearchDto;
import com.example.medicineapp.dto.response.ProductDetailResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProductDetailService {
    ProductDetailResponseDto getDtoBy(UUID id);

    Page<ProductDetailResponseDto> searchBy(ProductDetailSearchDto dto);

    ProductDetailResponseDto createBy(ProductDetailRequestDto dto);

    ProductDetailResponseDto updateBy(ProductDetailRequestDto dto);

    Boolean deleteBy(UUID id);

}
