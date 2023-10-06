package com.example.medicineapp.rest;

import com.example.medicineapp.dto.request.CartItemRequestDto;
import com.example.medicineapp.dto.request.search.CartItemSearchDto;
import com.example.medicineapp.dto.response.CartItemResponseDto;
import com.example.medicineapp.dto.response.MedicineResponse;
import com.example.medicineapp.service.CartItemService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart-item")
@RequiredArgsConstructor
public class RestCartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/{id}")
    public MedicineResponse<CartItemResponseDto> getDtoById (@PathVariable(value = "id") UUID id){
        return MedicineResponse.build(cartItemService.getDtoById(id));
    }

    @GetMapping("/page")
    public MedicineResponse<Page<CartItemResponseDto>> searchBy(CartItemSearchDto searchDto){
        return MedicineResponse.build(cartItemService.searchBy(searchDto));
    }

    @PostMapping
    public MedicineResponse<CartItemResponseDto> createBy(@NonNull @RequestBody CartItemRequestDto dto){
        return MedicineResponse.build(cartItemService.createBy(dto));
    }

    @PutMapping("/{id}")
    public MedicineResponse<CartItemResponseDto> updateBy(@NonNull @PathVariable(value = "id") UUID id,
                                                          @NonNull @RequestBody CartItemRequestDto dto){
        return MedicineResponse.build(cartItemService.updateBy(id, dto));
    }

    @DeleteMapping("/{id}")
    public  MedicineResponse<Boolean> deleteBy(@NonNull @PathVariable(value = "id") UUID id){
        return MedicineResponse.build(cartItemService.deleteBy(id));
    }

}
