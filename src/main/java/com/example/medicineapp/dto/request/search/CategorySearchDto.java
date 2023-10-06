package com.example.medicineapp.dto.request.search;

import com.example.medicineapp.dto.request.ProductRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategorySearchDto extends SearchDto{
    private String title;

    private String metaTitle;

    private String slug;

    private String content;

    private List<ProductRequestDto> productList;

}
