package com.example.medicineapp.dto.request;

import com.example.medicineapp.entity.OrderItemEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderRequestDto {

    private String session_id;

    private String token;

    private String status;

    private String subTotal;

    private String itemDiscount;

    private String tax;

    private String shipping;

    private String total;

    private double promo;

    private double discount;

    private String content;

    private int grandTotal;

    private List<OrderItemRequestDto> orderItemEntities;
}
