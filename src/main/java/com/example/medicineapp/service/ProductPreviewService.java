package com.example.medicineapp.service;


import com.example.medicineapp.dto.request.ProductPreviewRequestDto;
import com.example.medicineapp.dto.request.search.ProductPreviewSearchDto;
import com.example.medicineapp.dto.response.ProductPreviewResponseDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProductPreviewService {

    ProductPreviewResponseDto getDtoById(UUID id);

    Page<ProductPreviewResponseDto> searchBy(ProductPreviewSearchDto searchDto);

    ProductPreviewResponseDto createBy(ProductPreviewRequestDto dto);

    ProductPreviewResponseDto updateBy(UUID id, ProductPreviewRequestDto dto);

    Boolean deleteBy(UUID id);

}
