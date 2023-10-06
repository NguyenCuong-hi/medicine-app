package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tbl_product")
@Getter
@Setter
public class ProductEntity extends BaseObject {
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "title")
    private String title;

    @Column(name = "meta_title")
    private String metaTile;

    @Column(name = "slug")
    private String slug;

    @Column(name = "summary")
    private String summary;

    @Column(name= "type")
    private byte type;

    @Column(name = "sku")
    private String sku;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "quanity")
    private int quanity;

    @Column(name = "shop")
    private boolean shop;

    @Column(name = "publish_at")
    private Date publishAt;

    @Column(name = "start_at")
    private Date startAt;

    @Column(name= "end_at")
    private Date endAt;

    @Column(name = "content")
    private String content;

    @ManyToMany
    @JoinColumn(name = "category_id" )
    private List<CategoryEntity> categoryList;

}
