package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean validateAndSave(UserDTO user);
    String getNameByEmailAndPassword(String email,String password);
    Long countName(String name);
    Long countByEmail(String email);
    Long countByAltEmail(String altEmail);
    Long countByPhone(String phone);
    Long countByAltPhone(String altPhone);
    Long countByLocation(String location);
}

