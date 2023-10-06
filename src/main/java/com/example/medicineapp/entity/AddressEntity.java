package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_address")
public class AddressEntity extends BaseObject {
    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "address")
    private CustomerEntity customerEntity;

}
