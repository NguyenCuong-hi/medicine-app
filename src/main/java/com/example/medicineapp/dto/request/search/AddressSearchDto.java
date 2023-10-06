package com.example.medicineapp.dto.request.search;

import com.example.medicineapp.dto.request.CustomersRequestDto;

public class AddressSearchDto extends SearchDto{
    private String city;

    private String country;

    private String province;

    private String line1;

    private String line2;

    private String name;

    private CustomersRequestDto customer;
}
