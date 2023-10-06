package com.example.medicineapp.rest;

import com.example.medicineapp.dto.request.CartRequestDto;
import com.example.medicineapp.dto.request.search.CartSearchDto;
import com.example.medicineapp.dto.response.CartResponseDto;
import com.example.medicineapp.dto.response.MedicineResponse;
import com.example.medicineapp.service.CartService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class RestCartController {

    private final CartService cartService;

//    @GetMapping
//    public MedicineResponse<CartResponseDto> getDtoById(UUID id){
//        return MedicineResponse.build(cartService)
//    }

    @GetMapping("/page")
    public MedicineResponse<Page<CartResponseDto>> searchBy(CartSearchDto searchDto){
        return MedicineResponse.build(cartService.searchBy(searchDto));
    }

    @PostMapping
    public MedicineResponse<CartResponseDto> createBy(@NonNull @RequestBody CartRequestDto dto){
        return MedicineResponse.build(cartService.createBy(dto));
    }

    @PutMapping("/{id}")
    public MedicineResponse<CartResponseDto> updateBy(@NonNull @PathVariable(value = "id") UUID id,
                                                      @NonNull @RequestBody CartRequestDto dto){
        return MedicineResponse.build(cartService.updateBy(id,dto));
    }

    @DeleteMapping("/{id}")
    public MedicineResponse<Boolean> deleteBy(@NonNull @PathVariable(value = "id") UUID id){
        return MedicineResponse.build(cartService.deleteBy(id));
    }


}
