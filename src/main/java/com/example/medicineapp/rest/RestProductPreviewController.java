package com.example.medicineapp.rest;

import com.example.medicineapp.dto.request.ProductPreviewRequestDto;
import com.example.medicineapp.dto.request.search.ProductPreviewSearchDto;
import com.example.medicineapp.dto.response.MedicineResponse;
import com.example.medicineapp.dto.response.ProductPreviewResponseDto;
import com.example.medicineapp.service.ProductPreviewService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/preview-product")
@RequiredArgsConstructor
public class RestProductPreviewController {
    private final ProductPreviewService productPreviewService;

    @GetMapping("{id}")
    public MedicineResponse<ProductPreviewResponseDto> getByDto(@NonNull @PathVariable(value = "id") UUID id) {
        return MedicineResponse.build(productPreviewService.getDtoById(id));
    }

    @GetMapping("/page")
    public MedicineResponse<Page<ProductPreviewResponseDto>> searchBy(ProductPreviewSearchDto searchDto) {
        return MedicineResponse.build(productPreviewService.searchBy(searchDto));
    }

    @PostMapping
    public MedicineResponse<ProductPreviewResponseDto> createBy(@RequestBody ProductPreviewRequestDto dto) {
        return MedicineResponse.build(productPreviewService.createBy(dto));
    }

    @PutMapping("/{id}")
    public MedicineResponse<ProductPreviewResponseDto> updateBy(@NonNull @PathVariable(value = "id") UUID id,
                                                         @RequestBody ProductPreviewRequestDto dto) {
        return MedicineResponse.build(productPreviewService.updateBy(id, dto));
    }

    @DeleteMapping("/{id}")
    public MedicineResponse<Boolean> deleteBy(@NonNull @PathVariable(value = "id") UUID id) {
        return MedicineResponse.build(productPreviewService.deleteBy(id));
    }
}
