package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class TransactionEntity extends BaseObject {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "mode")
    private String mode;

    @Column(name = "status")
    private String status;

    @Column(name = "content")
    private String content;
}
