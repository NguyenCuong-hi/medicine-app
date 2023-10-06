package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "tbl_cart")
@Getter
@Setter
public class CartEntity extends BaseObject {
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItems;

    @Column(name = "status")
    private String status;

    @Column(name = "content")
    private String content;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

}
