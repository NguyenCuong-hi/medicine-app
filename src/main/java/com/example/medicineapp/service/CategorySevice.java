package com.example.medicineapp.service;

import com.example.medicineapp.dto.request.CategoryRequestDto;
import com.example.medicineapp.dto.request.search.CategorySearchDto;
import com.example.medicineapp.dto.response.CategoryResponseDto;
import lombok.NonNull;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CategorySevice{

    CategoryResponseDto createBy(@NonNull CategoryRequestDto categoryRequestDto);

    Page<CategoryResponseDto> searchBy(CategorySearchDto searchDto);

    CategoryResponseDto  updateBy(@NonNull UUID id, @NonNull CategoryRequestDto categoryRequestDto);

    Boolean deleteBy(@NonNull UUID id);

    Boolean deleteAll(List<UUID> idList);
}
