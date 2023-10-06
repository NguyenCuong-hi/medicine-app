package com.example.medicineapp.rest;

import com.example.medicineapp.dto.request.ProductRequestDto;
import com.example.medicineapp.dto.request.search.ProductSearchDto;
import com.example.medicineapp.dto.response.MedicineResponse;
import com.example.medicineapp.dto.response.ProductResponseDto;
import com.example.medicineapp.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class RestProductController {

    private final ProductService productService;

    @GetMapping("{id}")
    public MedicineResponse<ProductResponseDto> getByDto( @NonNull @PathVariable(value = "id") UUID id){
        return MedicineResponse.build(productService.getDtoById(id));
    }

    @GetMapping("/page")
    public MedicineResponse<Page<ProductResponseDto>> searchBy(ProductSearchDto searchDto){
        return MedicineResponse.build(productService.searchBy(searchDto));
    }

    @PostMapping
    public MedicineResponse<ProductResponseDto> createBy ( @RequestBody ProductRequestDto dto){
        return MedicineResponse.build(productService.createBy(dto));
    }

    @PutMapping("/{id}")
    public MedicineResponse<ProductResponseDto> updateBy(@NonNull @PathVariable(value = "id") UUID id,
                                                         @RequestBody ProductRequestDto dto){
        return MedicineResponse.build(productService.updateBy(id, dto));
    }

    @DeleteMapping("/{id}")
    public MedicineResponse<Boolean> deleteBy(@NonNull @PathVariable(value = "id") UUID id){
        return MedicineResponse.build(productService.deleteBy(id));
    }
}
