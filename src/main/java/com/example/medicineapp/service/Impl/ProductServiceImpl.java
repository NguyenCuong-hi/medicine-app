package com.example.medicineapp.service.Impl;

import com.example.medicineapp.dto.request.ProductRequestDto;
import com.example.medicineapp.dto.request.search.ProductSearchDto;
import com.example.medicineapp.dto.response.ProductResponseDto;
import com.example.medicineapp.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductResponseDto getDtoById(UUID id) {
        return null;
    }

    @Override
    public Page<ProductResponseDto> searchBy(ProductSearchDto searchDto) {
        return null;
    }

    @Override
    public ProductResponseDto createBy(ProductRequestDto dto) {
        return null;
    }

    @Override
    public ProductResponseDto updateBy(UUID id, ProductRequestDto dto) {
        return null;
    }

    @Override
    public Boolean deleteBy(UUID id) {
        return null;
    }
}
