package com.example.medicineapp.service;

import com.example.medicineapp.dto.request.CartRequestDto;
import com.example.medicineapp.dto.request.search.CartSearchDto;
import com.example.medicineapp.dto.response.CartResponseDto;
import lombok.NonNull;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CartService {

    CartResponseDto createBy(@NonNull CartRequestDto dto);

    Page<CartResponseDto> searchBy(CartSearchDto searchDto);

    CartResponseDto updateBy(@NonNull UUID id, @NonNull CartRequestDto CartRequestDto);

    Boolean deleteBy(@NonNull UUID id);

    Boolean deleteAll(List<UUID> idList);
}
