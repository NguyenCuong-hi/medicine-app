package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItemEntity extends BaseObject {
    @ManyToOne
    @JoinColumn(name = "oder_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Column(name = "sku")
    private String sku;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "content")
    private String content;
}
