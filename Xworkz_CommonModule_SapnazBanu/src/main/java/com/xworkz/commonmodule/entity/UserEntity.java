package com.xworkz.commonmodule.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name="user_table" )
@Entity
@NamedQuery(name="getNameByEmailAndPassword" ,query="select e.name from UserEntity e where e.email= :byemail and e.password = :bypassword ")
@NamedQuery(name="countName" , query ="select count(*) from UserEntity e where e.name =:SetName")
@NamedQuery(name = "countEmail", query = "select count(e) from UserEntity e where e.email = :SetEmail")
@NamedQuery(name = "countAltEmail", query = "select count(e) from UserEntity e where e.altEmail = :SetAltEmail")
@NamedQuery(name = "countPhone", query = "select count(e) from UserEntity e where e.phone = :SetPhone")
@NamedQuery(name = "countAltPhone", query = "select count(e) from UserEntity e where e.altPhone = :SetAltPhone")
@NamedQuery(name = "countLocation", query = "select count(e) from UserEntity e where e.location = :SetLocation")
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
