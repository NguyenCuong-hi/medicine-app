package com.example.medicineapp.dto.response;

import com.globits.core.dto.BaseObjectDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDto extends BaseObjectDto {
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

    private List<OrderItemResponseDto> orderItems;
}
