package com.example.medicineapp.dto.request;

import com.example.medicineapp.entity.CustomerEntity;
import com.globits.core.dto.BaseObjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto extends BaseObjectDto {

    private String city;

    private String country;

    private String province;

    private String line1;

    private String line2;

    private String name;

    private CustomersRequestDto customer;

}

