package com.xworkz.commonmodule.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDTO {

    @NotEmpty(message = "User name cannot be empty.")
    @Size(min = 3, max = 50, message = "User name should be between 3 and 50 characters.")
    private String name;

    @Digits(integer = 10, fraction = 0)
    private long phone;

    @Digits(integer = 10, fraction = 0)
    private long altPhone;

    @Email(message = "Email should be correct")
    private String email;

    @Email(message = "Alternative Email should be correct")
    private String altEmail;

    @NotEmpty(message = "Location name cannot be empty.")
    @Size(min = 3, max = 50, message = "Location name should be between 3 and 50 characters.")
    private String location;

    private Integer count ;
}