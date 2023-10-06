package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_cart_item")
@Getter
@Setter
public class CartItemEntity extends BaseObject {
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @Column(name = "sku")
    private String sku;

    @Column(name = "price")
    private String price;

    @Column(name = "discount")
    private float discount;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "content")
    private String content;
}
