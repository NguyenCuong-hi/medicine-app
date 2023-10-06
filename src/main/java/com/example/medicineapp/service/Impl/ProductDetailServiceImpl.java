package com.example.medicineapp.service.Impl;

import com.example.medicineapp.dto.request.ProductDetailRequestDto;
import com.example.medicineapp.dto.request.search.ProductDetailSearchDto;
import com.example.medicineapp.dto.response.ProductDetailResponseDto;
import com.example.medicineapp.service.ProductDetailService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Override
    public ProductDetailResponseDto getDtoBy(UUID id) {
        return null;
    }

    @Override
    public Page<ProductDetailResponseDto> searchBy(ProductDetailSearchDto dto) {
        return null;
    }

    @Override
    public ProductDetailResponseDto createBy(ProductDetailRequestDto dto) {
        return null;
    }

    @Override
    public ProductDetailResponseDto updateBy(ProductDetailRequestDto dto) {
        return null;
    }

    @Override
    public Boolean deleteBy(UUID id) {
        return null;
    }
}
