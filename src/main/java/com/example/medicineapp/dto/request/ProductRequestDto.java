package com.example.medicineapp.dto.request;

import com.globits.core.dto.BaseObjectDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
public class ProductRequestDto extends BaseObjectDto {

    private int user_id;

    private String title;

    private String metaTile;

    private String slug;

    private String summary;

    private byte type;

    private String sku;

    private double price;

    private double discount;

    private int quanity;

    private boolean shop;

    private Date publishAt;

    private Date startAt;

    private Date endAt;

    private String content;

    private List<CategoryRequestDto> categoryList;
}
