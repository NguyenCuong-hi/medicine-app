package com.example.medicineapp.dto.response;

import com.example.medicineapp.dto.request.AddressRequestDto;
import com.globits.core.dto.BaseObjectDto;

public class CustomersResponseDto extends BaseObjectDto {

    private String firstName;

    private String midName;

    private String lastName;

    private String mobile;

    private String email;

    private String password;

    private Boolean isAdmin;

    private String vendor;

    private String registedAt;

    private String lastLogin;

    private String intro;

    private String profile;

    private AddressResponseDto address;
}
