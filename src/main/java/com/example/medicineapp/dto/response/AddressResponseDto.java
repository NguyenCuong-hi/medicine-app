package com.example.medicineapp.dto.response;

import com.example.medicineapp.dto.request.CustomersRequestDto;
import com.globits.core.dto.BaseObjectDto;

public class AddressResponseDto extends BaseObjectDto {
    private String city;

    private String country;

    private String province;

    private String line1;

    private String line2;

    private String name;

    private CustomersResponseDto customer;
}
