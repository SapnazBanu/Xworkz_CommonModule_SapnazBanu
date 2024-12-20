package com.xworkz.commonmodule.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String altEmail;
    private String phone;
    private String altPhone;
    private String location;
}
