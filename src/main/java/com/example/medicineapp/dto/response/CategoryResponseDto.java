package com.example.medicineapp.dto.response;

import com.example.medicineapp.dto.request.ProductRequestDto;
import com.globits.core.dto.BaseObjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponseDto extends BaseObjectDto {
    private String title;

    private String metaTitle;

    private String slug;

    private String content;

    private List<ProductResponseDto> productList;
}
