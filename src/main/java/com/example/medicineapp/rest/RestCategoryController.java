package com.example.medicineapp.rest;

import com.example.medicineapp.dto.request.CategoryRequestDto;
import com.example.medicineapp.dto.request.search.CategorySearchDto;
import com.example.medicineapp.dto.response.CategoryResponseDto;
import com.example.medicineapp.dto.response.MedicineResponse;
import com.example.medicineapp.service.CategorySevice;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor

public class RestCategoryController {

    @Autowired
    private final CategorySevice categorySevice;

    @GetMapping("/page")
    public MedicineResponse<Page<CategoryResponseDto>> searchBy(CategorySearchDto searchDto){
        return MedicineResponse.build(categorySevice.searchBy(searchDto));
    }

    @PostMapping
    public MedicineResponse<CategoryResponseDto> createBy(@RequestBody @NonNull CategoryRequestDto categoryRequestDto){
        return MedicineResponse.build(categorySevice.createBy(categoryRequestDto));
    }

    @PutMapping("{id}")
    public MedicineResponse<CategoryResponseDto>  updateBy(@NonNull CategoryRequestDto categoryRequestDto, @PathVariable @NonNull UUID id){
        return MedicineResponse.build(categorySevice.updateBy(id, categoryRequestDto));
    }

    @DeleteMapping("{id}")
    public MedicineResponse<Boolean> deleteBy ( @PathVariable @NonNull UUID id){
        return MedicineResponse.build(categorySevice.deleteBy(id));
    }

}
