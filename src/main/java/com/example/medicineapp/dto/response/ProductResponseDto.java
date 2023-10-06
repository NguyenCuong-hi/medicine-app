package com.example.medicineapp.dto.response;

import com.globits.core.dto.BaseObjectDto;
import java.sql.Date;
import java.util.List;

public class ProductResponseDto extends BaseObjectDto {

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

    private List<CategoryResponseDto> categoryList;
}
