package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customers")
@Getter
@Setter
public class CustomerEntity extends BaseObject {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "registed_at")
    private String registedAt;

    @Column(name = "last_login")
    private String lastLogin;

    @Column(name = "intro")
    private String intro;

    @Column(name = "profile")
    private String profile;

    @OneToOne(mappedBy = "")
    private AddressEntity address;

}
