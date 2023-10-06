package com.example.medicineapp.dto.request.search;

import lombok.Getter;

import java.sql.Date;

@Getter
public class ProductSearchDto extends SearchDto{
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
}
