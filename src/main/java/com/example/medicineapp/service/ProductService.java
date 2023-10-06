package com.example.medicineapp.service;

import com.example.medicineapp.dto.request.ProductRequestDto;
import com.example.medicineapp.dto.request.search.ProductSearchDto;
import com.example.medicineapp.dto.response.ProductResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProductService {
    ProductResponseDto getDtoById(UUID id);
    Page<ProductResponseDto> searchBy(ProductSearchDto searchDto);
    ProductResponseDto createBy(ProductRequestDto dto);
    ProductResponseDto updateBy(UUID id, ProductRequestDto dto);
    Boolean deleteBy(UUID id);

}
