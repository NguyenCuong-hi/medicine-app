package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_order")
@Getter
@Setter
public class OrderEntity extends BaseObject {
    @Column(name = "session_id")
    private String session_id;

    @Column(name = "token")
    private String token;

    @Column(name = "status")
    private String status;

    @Column(name = "sub_total")
    private String subTotal;

    @Column(name = "item_discount")
    private String itemDiscount;

    @Column(name = "tax")
    private String tax;

    @Column(name = "shipping")
    private String shipping;

    @Column(name = "total")
    private String total;

    @Column(name = "promo")
    private double promo;

    @Column(name = "disount")
    private double discount;

    @Column(name = "content")
    private String content;

    @Column(name = "grand_total")
    private int grandTotal;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntities;

}
