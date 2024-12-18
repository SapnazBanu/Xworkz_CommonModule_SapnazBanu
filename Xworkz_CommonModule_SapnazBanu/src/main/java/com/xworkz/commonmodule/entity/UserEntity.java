package com.xworkz.commonmodule.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name="user_table" )
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email")
    private String email;

    @Column(name="user_altEmail")
    private String altEmail;

    @Column(name="user_phone")
    private String phone;

    @Column(name="user_altPhone")
    private String altPhone;

    @Column(name="user_location")
    private String location;

    @Column(name="user_password")
    private String password;
}
