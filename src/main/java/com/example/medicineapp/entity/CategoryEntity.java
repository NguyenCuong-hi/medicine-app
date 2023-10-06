package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_category", catalog = "")
@Getter
@Setter
public class CategoryEntity extends BaseObject {
    @Column(name = "title")
    private String title;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "slug")
    private String slug;

    @Column(name = "content")
    private String content;

    @ManyToMany(mappedBy = "categoryList")
    private List<ProductEntity> productList;
}
