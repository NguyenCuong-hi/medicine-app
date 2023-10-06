package com.example.medicineapp.dto.request;

import com.example.medicineapp.entity.AddressEntity;
import com.globits.core.dto.BaseObjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomersRequestDto extends BaseObjectDto {

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

    private AddressRequestDto address;
}
