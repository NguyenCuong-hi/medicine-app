package com.example.medicineapp.dto.request;

import com.globits.core.dto.BaseObjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryRequestDto extends BaseObjectDto {

    private String title;

    private String metaTitle;

    private String slug;

    private String content;

    private List<ProductRequestDto> productList;

}
